package com.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionalInterfaces03 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,8,5,3,2);

       //This is a functional interface whose functional method is test(Object).
        Predicate<Integer> integerPredicate = x -> x % 2 == 0;

        //Represents a function that accepts one argument and produces a result.
        //This is a functional interface whose functional method is apply(Object).
        Function<Integer, Integer> integerIntegerFunction = x -> x * x;

        //Represents an operation that accepts a single input argument and returns no result.
        // Unlike most other functional interfaces, Consumer is expected to operate via side-effects.
        //This is a functional interface whose functional method is accept(Object).
        Consumer<Integer> println = System.out::println;

        numbers.stream()
                .filter(integerPredicate)
                .map(integerIntegerFunction)
                .forEach(println);

    }
}
