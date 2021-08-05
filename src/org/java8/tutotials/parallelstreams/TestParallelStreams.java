package org.java8.tutotials.parallelstreams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class TestParallelStreams {

    public static void main(String args[]){

        long t0 = System.nanoTime();
        int size = 10000000;
        List<String> values = new ArrayList<>(10000000);
        for (int i = 0; i < size; i++) {
            UUID uuid = UUID.randomUUID();
            values.add(uuid.toString());
        }
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0));
        System.out.println("total size : "+ values.size());

        useStreamSort(values);
        useParallelStreamSort(values);
    }

    public static void useStreamSort(List<String> values){
        long t0 = System.nanoTime();
        long count = values.stream().sorted().count();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0));
        System.out.println("total count : " + count);
    }

    public static void useParallelStreamSort(List<String> values){
        long t0 = System.nanoTime();
        long count = values.parallelStream().sorted().count();
        System.out.println(TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - t0));
        System.out.println("total count : " + count);
    }

}
