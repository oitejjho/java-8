package org.java8.tutotials.lambdaexp;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TestLambda {


    public static void main(String args[]){

        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");

        //conventional way to sort
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });

        //lambda expression
        // way 1
        Collections.sort(names, (String a, String b) -> {
            return b.compareTo(a);
        });
        Collections.sort(names, Comparator.reverseOrder());
        // way 2
        names.sort((a, b) -> b.compareTo(a));
        names.sort(Comparator.reverseOrder());


        names.sort(Comparator.naturalOrder());


    }



}
