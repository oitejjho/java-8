package org.java8.tutotials.optionals;

import java.util.Locale;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TestOptionals {


    public static void main(String[] args) throws Exception {


        Optional<String> stringOptional = Optional.of("bob");

        System.out.println(stringOptional.isPresent());
        System.out.println(stringOptional.get());
        System.out.println(stringOptional.orElse("fallback"));

        //add consumer in optionals
        Consumer<String> greetings = p -> System.out.println("hello " + p);
        stringOptional.ifPresent(greetings);

        //add predicate in optionals
        Predicate<String> predicate = s -> s.startsWith("b");
        System.out.println(stringOptional.filter(predicate).get());

        // add functions in optionals
        Function<String , String> function = b -> b.toUpperCase();
        System.out.println(stringOptional.map(function).get().toUpperCase(Locale.ROOT));

        // add supplier in optionals
        Supplier<Double> supplier = Math::random;
        System.out.println(Optional.empty().orElseGet(supplier));
        //System.out.println(Optional.empty().orElseThrow(() -> new Exception()));

        System.out.println(Optional.empty().orElse("empty"));




    }

}
