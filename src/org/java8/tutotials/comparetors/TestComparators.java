package org.java8.tutotials.comparetors;

import java.util.Comparator;

public class TestComparators {


    public static void main(String args[]){


        Comparator<String> comparator = Comparator.naturalOrder();

        System.out.println(comparator.compare("hello", "world"));
    }

}
