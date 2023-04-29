package com.programming;

import java.util.List;

public class FunctionalProgramming02 {
    public static void main(String[] args) {

        List<Integer> numbers = List.of(1, 2, 3, 455, 66, 77, 88, 9, 0);
        System.out.println(addListFunctional(numbers));
    }

    private static int addListFunctional(List<Integer> numbers) {

        //Stream of number -> One result value
        //Combine them into one result => One value
        // initial value 0  FunctionalProgramming02 :: sum

        return numbers.stream()
                .reduce(0,FunctionalProgramming02::sum);
    }

    private static Integer sum(int a, int b) {
        return a+b;
    }


}