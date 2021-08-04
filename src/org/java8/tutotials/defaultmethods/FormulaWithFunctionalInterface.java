package org.java8.tutotials.defaultmethods;

@FunctionalInterface
public interface FormulaWithFunctionalInterface {

    void calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }

}
