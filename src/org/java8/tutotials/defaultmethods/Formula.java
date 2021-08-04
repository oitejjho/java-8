package org.java8.tutotials.defaultmethods;

public interface Formula {

    double calculate(int a);

    //double calculate1(int a, int b);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
