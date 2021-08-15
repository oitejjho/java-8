package org.java8.tutotials.streams;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NonInterference {


    public static void main(String[] args) {
        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

        //interferenceExampleNonConcurrentSource(stringCollection);

        List<String> stringCollection1 = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        interferenceExampleNonConcurrentSource1(stringCollection1);
        interferenceExampleNonConcurrentSourceAddBeforeTerminalOperation(stringCollection);

        Queue<String> stringConcurrentCollection = new ConcurrentLinkedQueue<>();
        stringConcurrentCollection.add("ddd2");
        stringConcurrentCollection.add("aaa2");
        stringConcurrentCollection.add("bbb1");
        stringConcurrentCollection.add("aaa1");
        stringConcurrentCollection.add("bbb3");
        stringConcurrentCollection.add("ccc");
        stringConcurrentCollection.add("bbb2");
        stringConcurrentCollection.add("ddd1");

        interferenceExampleConcurrentSource(stringConcurrentCollection);

    }


    public static void interferenceExampleNonConcurrentSource(List<String> stringList) {

        //A behavioral parameter is said to interfere with
        // a non-concurrent data source if it modifies,
        // or causes to be modified, the stream's data source.

        //java.util.ConcurrentModificationException
        // because we are modifying our source(non concurrent source)
        stringList
                .stream()
                .filter(s -> s.startsWith("a"))//predicate
                .map(s -> stringList.add(s.toUpperCase()))//function
                .collect(Collectors.toList());//consumer


    }

    public static void interferenceExampleNonConcurrentSource1(List<String> stringList) {

        // this code snippet will not raise any exception
        // since the source is converted to synchronized collection
        // so modifications on source(concurrent) are allowed
        Collection<String> synchronizedStringCollection = Collections.synchronizedCollection(stringList);
        synchronizedStringCollection.stream()
                .filter(s -> s.startsWith("a"))//predicate
                .map(s -> stringList.add(s.toUpperCase()))//function
                .collect(Collectors.toList());//consumer


    }

    public static void interferenceExampleNonConcurrentSourceAddBeforeTerminalOperation(List<String> stringList) {

        // this code snippet will not raise any exception
        // since the stream is created but terminal operation is not called
        // so modifications of source(irrespective of non-concurrent or concurrent modifications are allowed
        Stream<String> stream = stringList
                .stream()
                .filter(s -> s.startsWith("a"));
        stringList.add("hello");
        List<String> outputStringList = stream.collect(Collectors.toList());



    }

    public static void interferenceExampleConcurrentSource(Queue<String> stringConcurrentCollection) {

        //A behavioral parameter is said to interfere with
        // a non-concurrent data source if it modifies,
        // or causes to be modified, the stream's data source.

        // no java.util.ConcurrentModificationException
        // because we are modifying our source(concurrent source)
        stringConcurrentCollection
                .stream()
                .filter(s -> s.startsWith("a"))//predicate
                .map(s -> stringConcurrentCollection.add(s.toUpperCase()))//function
                .collect(Collectors.toList());//consumer
    }

}
