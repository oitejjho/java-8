package org.java8.tutotials.streams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ThreadLocalRandom;

public class TestStream1 {


    public static void main(String[] args) {

        List<Person> list = Collections.synchronizedList(new ArrayList<>());
        ConcurrentLinkedQueue<Person> personQueue = new ConcurrentLinkedQueue<>();
        Runnable publishEvent = () -> {
            while (list.size() < 100) {
                synchronized (list) {
                    list.add(new Person(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 99 + 1)));
                }
                System.out.println("Thread = " + Thread.currentThread().getName());
                try {
//                    personQueue.add(new Person(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 99 + 1)));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(list.toString());
            }
        };

        Runnable consumingEvents = () -> {

            while (list.size() % 10 == 0) {
                list.stream()
                        .forEach(person -> {
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Name : " + person.name + " -> Age : " + person.age);
                        });
//                System.out.println("Name : " + list.get(0).name + " -> Age : " + list.get(0).age);
            }
            /*list
                    .stream()
                    .forEach(person -> System.out.println("Name : " + person.name + " -> Age : " + person.age));*/
            /*while (list.size() > 0) {
                synchronized (list){
                    list.add(new Person(UUID.randomUUID().toString(), ThreadLocalRandom.current().nextInt(1, 99 + 1)));
                }
                System.out.println("Thread = " + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //System.out.println(list.toString());
            }*/
        };

        new Thread(publishEvent, "pub1").start();
        new Thread(publishEvent, "pub2").start();
        new Thread(publishEvent, "pub3").start();

        new Thread(consumingEvents, "consumer1").start();


    }


}


class EventGenerator {

    public static void generateEvent(List<Person> events) {

        new Thread(() -> {
            Long count = 0L;
            while (true) {

                System.out.println("generating event " + (++count));
                try {
                    int age = ThreadLocalRandom.current().nextInt(1, 99 + 1);
                    events.add(new Person(UUID.randomUUID().toString(), age));
                    Thread.sleep(500);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


}


class Person {

    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
