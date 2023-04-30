package com.programming;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise02 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 54, 62, 11, 44, 90);

        // Square every number in a list and find the sum of squares
       ///int sum = squareNumberAndFindSum(numbers);
        int sum= sumOfOddNumberInList(numbers);
     //  System.out.println(sum);

       // Crate a List with even numbers filtered from the numbers list
        List<Integer> evenNumbers=getEvenNumber(numbers);
        evenNumbers.stream()
                .forEach(System.out::println);
    }

    private static List<Integer> getEvenNumber(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer%2==0).collect(Collectors.toList());
    }

    private static int sumOfOddNumberInList(List<Integer> numbers) {
        return numbers.stream()
                .filter(integer -> integer%2==1)
                .reduce(0,Integer::sum);
    }

    private static int squareNumberAndFindSum(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number*number)
                .reduce(0,(x,y)->x+y);

    }


}
