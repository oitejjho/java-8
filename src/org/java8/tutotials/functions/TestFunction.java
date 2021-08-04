package org.java8.tutotials.functions;

import java.util.function.Function;

public class TestFunction {

    public static void main(String args[]){

        Function<String, Integer> toInteger = Integer::valueOf;
        //function chainin
        Function<String, String> toString = toInteger.andThen(String::valueOf);


        System.out.println(toString.apply("123"));


    }
}
