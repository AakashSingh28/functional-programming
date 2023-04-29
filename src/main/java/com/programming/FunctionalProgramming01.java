package com.programming;

import java.util.List;

public class FunctionalProgramming01 {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(1,2,3,455,66,77,88,9,0));
    }

    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for (int num:numbers) {
            System.out.println(" "+num);
        }
    }
}