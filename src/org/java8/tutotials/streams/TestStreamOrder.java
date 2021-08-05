package org.java8.tutotials.streams;

import java.util.stream.Stream;

public class TestStreamOrder {

    public static void main(String[] args) {


        // vertical chaining and vertical execution of pipeline
        /*Stream.of("d", "a", "b", "e", "f")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach: " + s));*/



        //why order is necessary
        Stream.of("d", "a", "b", "e", "a", "g")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));

        //map and filter are called 6 times
        //we can reduce the calls and optimize the execution by changing the pipeline
        System.out.println("1---------------------------------------------");
        Stream.of("d", "a", "b", "e", "a", "g")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));


        //how state full intermediate operations stop execution of other intermediate operations
        //state full operation will execute horizontally
        System.out.println("2---------------------------------------------");
        Stream.of("d", "a", "b", "e", "a", "g")
                .sorted((o1, o2) -> {//state full operation
                    System.out.printf("sort: %s; %s\n", o1, o2);
                    return o1.compareTo(o2);
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));

        //we can optimize the execution call by reordering the intermediate operations
        // filter will execute horizontally when next operation is stateful i.e. sorted
        System.out.println("3---------------------------------------------");
        Stream.of("d", "a", "b", "e", "a", "g")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .sorted((o1, o2) -> {//state full operation
                    System.out.printf("sort: %s and %s\n", o1, o2);
                    return o1.compareTo(o2);
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
        System.out.println("4---------------------------------------------");
        Stream.of("d", "a", "b", "e", "a", "g")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .sorted((o1, o2) -> {//state full operation
                    System.out.printf("sort: %s; %s\n", o1, o2);
                    return o1.compareTo(o2);
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

}
