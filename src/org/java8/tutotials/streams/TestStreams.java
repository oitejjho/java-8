package org.java8.tutotials.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class TestStreams {

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

        //intermediate operations
        //=====================================================//
        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))//predicate
                .forEach(s -> System.out.println(s));//consumer
        stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))//predicate
                .map(String::toUpperCase)//function
                .forEach(System.out::println);//consumer
        //=====================================================//


        //terminal operation
        //=====================================================//
        //match
        Predicate<String> startWithA = s -> s.startsWith("a");
        Predicate<String> startWithZ = s -> s.startsWith("z");
        boolean allMatchWithA = stringCollection
                .stream()
                .allMatch(startWithA);
        System.out.println(allMatchWithA);
        boolean anyMatchWithA = stringCollection
                .stream()
                .anyMatch(startWithA);
        System.out.println(anyMatchWithA);
        boolean noneMatchWithZ = stringCollection
                .stream()
                .noneMatch(startWithZ);
        System.out.println(noneMatchWithZ);

        //count
        long countStartWithA = stringCollection
                .stream()
                .filter(s -> s.startsWith("a"))
                .count();
        System.out.println("start with a " + countStartWithA);

        //reduce
        Optional<String> reduced = stringCollection
                .stream()
                .sorted()
                .filter(s -> s.startsWith("a"))
                .reduce((input1, input2) -> input1 + "$" + input2);
        System.out.println(reduced.orElse("nothing found"));
        //=====================================================//

    }
}
