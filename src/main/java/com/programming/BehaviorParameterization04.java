package com.programming;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class BehaviorParameterization04 {

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1,2,3,4,8,5,3,2);

     //   Predicate<Integer> predicate = x -> x % 2 == 0;

        filterAndPrint(numbers, x->x%2==0);
        System.out.println();
        filterAndPrint(numbers, x->x%3==0);
        System.out.println();

        List<Integer> numberList= getCollect(numbers, x -> x * x);
        numberList.stream().forEach(System.out::println);

    }

    private static List<Integer> getCollect(List<Integer> numbers, Function<Integer, Integer> integerFunction) {
        return numbers.stream().map(integerFunction).collect(Collectors.toList());
    }

    private static void filterAndPrint(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}
