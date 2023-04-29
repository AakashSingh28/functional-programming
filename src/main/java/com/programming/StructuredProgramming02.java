package com.programming;

import java.util.List;

public class StructuredProgramming02 {
    public static void main(String[] args) {


        List<Integer> numbers = List.of(1, 2, 3, 455, 66, 77, 88, 9, 0);
        int sum=addListStructured(numbers);
        System.out.println(sum);
    }

    private static int addListStructured(List<Integer> numbers) {
        int sum=0;
        for (int num :
                numbers) {
            sum+=num;
        }
        return sum;
    }


}