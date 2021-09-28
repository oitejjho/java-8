package org.java8.tutotials.suppliers;

import java.util.function.Supplier;

public class TestSuppliers {

    public static void main(String args[]){


        //suppliers are different than functions
        // function takes parameter and produces result
        // supplier only produces result


        Supplier<Double> stringSupplier = Math::random;
        System.out.println(stringSupplier.get());


    }
}
