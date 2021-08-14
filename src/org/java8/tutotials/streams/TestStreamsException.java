package org.java8.tutotials.streams;

import org.java8.tutotials.defaultmethods.FunctionWithException;
import org.java8.tutotials.either.Either;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TestStreamsException {

    public static void main(String[] args) {

        List<String> stringCollection = new ArrayList<>();
        stringCollection.add("ddd2");
        stringCollection.add("aaa2");
        stringCollection.add("bbb1");
        stringCollection.add("aaa1");
        stringCollection.add("bbb3");
        stringCollection.add("ccc");
        stringCollection.add("bbb2");
        stringCollection.add("ddd1");

//        print(stringCollection.get(0));
        print(stringCollection);

    }



    public static void print(List<String> address){

         List<String> list = address.stream()
                .map(Either.lift(TestStreamsException::getString))
                .map(either -> {
                    if(either.isLeft())
                        return either.getLeft().get().toString();
                    return either.getRight().get().toString();
                }).collect(Collectors.toList());




    }


    public static String getString(String s) throws Exception {
        if(s.startsWith("c")) throw new Exception("Some exception");
        return s;
    }
}
