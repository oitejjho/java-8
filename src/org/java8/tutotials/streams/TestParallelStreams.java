package org.java8.tutotials.streams;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class TestParallelStreams {


    public static void main(String args[]){

        Arrays.asList("a", "a", "b", "c", "c", "e", "d", "b",
                "a", "a", "b", "c", "c", "e", "d", "b",
                "a", "a", "b", "c", "c", "e", "d", "b",
                "a", "a", "b", "c", "c", "e", "d", "b","a", "a", "b", "c", "c", "e", "d", "b")
                .parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.startsWith("a") || s.startsWith("b");
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n",
                            s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                // as the number is very small maybe less the granular number so parallel sort is not being used
                // its using sequential sorting
                .sorted((s1, s2) -> {
                    System.out.format("sort: %s <> %s [%s]\n",
                            s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n",
                        s, Thread.currentThread().getName()));//for each other is not guaranteed


    }


}
