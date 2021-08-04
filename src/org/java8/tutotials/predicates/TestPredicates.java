package org.java8.tutotials.predicates;

import java.util.Objects;
import java.util.function.Predicate;

public class TestPredicates {

    public static void main(String args[]){


        Predicate<String> predicate = (s) -> s.length() > 0;
        Predicate<String> predicateAnd = (s) -> s.startsWith("f");
        Predicate<String> predicateOr = (s) -> s.startsWith("s");


        System.out.println(predicate.test("foo"));

        //predicate chaining
        System.out.println(predicate.and(predicateAnd).or(predicateOr).test("foo"));

        Predicate<Boolean> isNull = Objects::isNull;

        Predicate<String> isEmpty = String::isEmpty;
        System.out.println(isEmpty.test("test"));


    }
}
