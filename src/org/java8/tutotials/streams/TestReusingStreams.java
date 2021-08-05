package org.java8.tutotials.streams;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestReusingStreams {

    public static void main(String[] args) {

        Stream<String> stream = Stream.of("d", "a", "b", "e", "a", "g")
                .filter(s -> s.startsWith("a"));

        System.out.println(stream.anyMatch(s -> true));
        //System.out.println(stream.noneMatch(s -> true)); is creating exception
        //we cannot reuse stream

        Supplier<Stream<String>> supplier = () ->
                Stream.of("d", "a", "b", "e", "a", "g")
                        .filter(s -> s.startsWith("a"));

        System.out.println(supplier.get().anyMatch(s -> true));
        System.out.println(supplier.get().noneMatch(s -> true));// this wont create any exception

    }
}
