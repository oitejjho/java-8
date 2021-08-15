package org.java8.tutotials.streams;

import java.util.stream.IntStream;

public class StateFulVsStateLess {

    private static int count = 0;

    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            IntStream stream = IntStream.range(1, 1000);
            stateFulExample(stream);
        }

        for (int i = 0; i < 5; i++) {
            IntStream stream = IntStream.range(1, 1000);
            stateFulExampleSolution(stream);

        }


    }


    public static void stateFulExample(IntStream stream) {

        // Stream pipeline results may be nondeterministic or incorrect
        // if the behavioral parameters to the stream operations are stateful.

        count = 0;

        //finding the sum of even numbers
        int sum = stream.parallel()
                .filter(i -> {
                    boolean b = i % 2 == 0;
                    if (b) {
                        count++;//updating count is making lambda stateful.
                    }
                    return b;
                })
                .sum();

        System.out.printf("sum :%d  count:%d%n", sum, count);

    }

    public static void stateFulExampleSolution(IntStream stream) {

        int[] evenList = stream.parallel()
                .filter(number -> number % 2 == 0)
                .toArray();


        int sum = IntStream.of(evenList).parallel().filter(i -> i % 2 == 0).sum();
        System.out.printf("sum :%d  count:%d%n", sum, evenList.length);

    }

}
