package com.programming;

import java.util.List;

public class FunctionalProgramming01 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 455, 66, 77, 88, 9, 0);
       // printAllNumbersInFunctional(numbers);
       // printEvenNumbersInFunctional(numbers);
        printSquareOfEvenNumbersInFunctional(numbers);
    }

    private static void printSquareOfEvenNumbersInFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(integer -> integer%2==0)
                //mapping -x -> X*X
                .map(number -> number*number)
                .forEach(System.out::println);
    }

    private static void print(int number){
        System.out.println(number);
    }
    private static void printAllNumbersInFunctional(List<Integer> numbers) {
     //   numbers.stream().forEach(integer -> System.out.println(integer));
        numbers.stream()
                .forEach(FunctionalProgramming01::print);  // This is called Method Reference
        // Or
        numbers.stream()
                .forEach(System.out :: println);
    }
    private static  boolean isEven(int number){
         return number%2==0;
    }

    private static void printEvenNumbersInFunctional(List<Integer> numbers) {

        numbers.stream()
                //Filter - Only allow Even Numbers
                .filter(FunctionalProgramming01:: isEven)
                .forEach(System.out :: println);

        // Or

        numbers.stream()
                // With lambda Expression
                .filter(number -> number%2 == 0).forEach(System.out::println);

    }
}