package com.programming;

import java.util.List;

public class FunctionalProgramming02 {
    public static void main(String[] args) {

        printAllNumbersInFunctional(List.of(1,2,3,455,66,77,88,9,0));
    }

    private static void print(int number){
        System.out.println(number);
    }
    private static void printAllNumbersInFunctional(List<Integer> numbers) {
     //   numbers.stream().forEach(integer -> System.out.println(integer));
        numbers.stream()
                .forEach(FunctionalProgramming02::print);  // This is called Method Reference
    }
}