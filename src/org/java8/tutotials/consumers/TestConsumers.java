package org.java8.tutotials.consumers;

import java.util.function.Consumer;

public class TestConsumers {

    public static void main(String args[]){


        //Consumers represent operations to be performed on a single input argument.

        Consumer<Integer> greeter = (p) -> System.out.println("Hello, " + p);
        Consumer<Integer> goodbye = (p) -> System.out.println("bye, " + p);

        //Consumer chainin
        greeter.andThen(goodbye).accept(123);


    }

}
