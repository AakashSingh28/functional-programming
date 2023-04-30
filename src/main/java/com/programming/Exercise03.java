package com.programming;

import java.util.List;
import java.util.function.BinaryOperator;

public class Exercise03 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 54, 62, 11, 44, 90);


        /*
        Represents an operation upon two operands of the same type,
         producing a result of the same type as the operands. This is a specialization of
         BiFunction for the case where the operands and the result are all of the same type.
        This is a functional interface whose functional method is apply(Object, Object).
        */

        BinaryOperator<Integer> sum = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) {
                return integer+integer2;
            }
        };

        System.out.println(numbers.stream().reduce(0, sum));
    }


}
