package org.java8.tutotials.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class SideEffects {

    private static final int count = 0;

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

        findMatchWithSideEffect(stringCollection);


    }


    public static void findMatchWithSideEffect(List<String> list) {
        List<String> matchString = new ArrayList<>();
        // This code unnecessarily uses side-effects.
        // If executed in parallel, the non-thread-safety of ArrayList would cause incorrect results,
        // and adding needed synchronization would cause contention, undermining the benefit of parallelism.
        list.parallelStream().filter(s -> s.startsWith("a")).forEach(s -> matchString.add(s));

        //The pipeline operations
        // ForEach(),
        // ForEachOrdered() and
        // peek() which returns void, are meant to produce side effects.

        //We should only apply side-effects from these operations if we don't care about the order.

    }

    public static void findMatchWithNoSideEffect(List<String> list) {
        List<String> matchString = list.parallelStream().filter(s -> s.startsWith("a")).collect(Collectors.toList());
    }

}
