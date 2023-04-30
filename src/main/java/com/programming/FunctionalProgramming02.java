package com.programming;

import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming02 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 20, 66, 77, 88, 9, 0);
        System.out.println(addListFunctional(numbers));

        List<Integer> doubleNumbers=doubleList(numbers);
        doubleNumbers.stream().forEach(System.out::println);
    }

    private static List<Integer> doubleList(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number*number)
                .collect(Collectors.toList());
    }

    private static int addListFunctional(List<Integer> numbers) {

        //Stream of number -> One result value
        //Combine them into one result => One value
        // initial value 0  FunctionalProgramming02 :: sum

        /*return numbers.stream()
                .reduce(0,FunctionalProgramming02::sum);

         Or
        return numbers.stream()
                .reduce(0,(x,y)->x+y);
         Or */

        return numbers.stream()
                .reduce(0,Integer::sum);
    }

    private static Integer sum(int aggregate, int nextNumber) {
        return aggregate+nextNumber;
    }


}