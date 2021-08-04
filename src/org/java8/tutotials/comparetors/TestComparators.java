package org.java8.tutotials.comparetors;

import java.util.Comparator;

public class TestComparators {


    public static void main(String args[]){


        Comparator<String> comparator = (p1, p2) -> p1.compareTo(p2);

        System.out.println(comparator.compare("hello", "world"));
    }

}
