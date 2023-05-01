package com.programming;
import java.util.List;
import java.util.Random;
import java.util.function.*;

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


        //Represents an operation upon two operands of the same type, producing a result of the same type as the operands.
        // This is a specialization of BiFunction for the case where the operands and the result are all of the same type
        BinaryOperator<Integer> sumBinaryOperator=(x,y) -> x+y;

        // No input but return something
        // Supplier<Integer> randomIntegerSupplier = () -> 2;   // () means no parameter
        // Or

        Supplier<Integer> randomIntegerSupplier = () -> {
            return new Random().nextInt( 1000);
        };

        System.out.println("randomIntegerSupplier "+randomIntegerSupplier.get());

        // Represents an operation on a single operand that produces a result of the same type as its operand.
        // This is a specialization of Function for the case where the operand and result are of the same type.
        //This is a functional interface whose functional method is apply(Object).
        UnaryOperator<Integer> unaryOperator= (x) -> 3*x;
        System.out.println("unaryOperator "+unaryOperator.apply(10));

        //Represents a predicate (boolean-valued function) of two arguments.
        // This is the two-arity specialization of Predicate.
        BiPredicate<Integer,String> integerSystemBiPredicate= (num,str)-> {
            return num<10 && str.length()>5;
        };
        System.out.println("integerSystemBiPredicate "+integerSystemBiPredicate.test(9,"Long String"));


        //Represents a function that accepts two arguments and produces a result.
        // This is the two-arity specialization of Function.
        //This is a functional interface whose functional method is apply(Object, Object).
        BiFunction<Integer,String,String> biFunction= (num,str)->{
            return num+" *** "+str;
        };
        System.out.println(biFunction.apply(10,"Number"));

        // Represents an operation that accepts two input arguments and returns no result.
        // This is the two-arity specialization of Consumer. Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects.
        //This is a functional interface whose functional method is accept(Object, Object).
        BiConsumer<Integer,Integer> integerIntegerBiConsumer=(num1,num2) -> System.out.println("BiConsumer "+num1*num2);
        integerIntegerBiConsumer.accept(10,10);



        // Now we have IntBinaryOperator,DoubleBinaryOperator ..... like more and this will be more efficient than BinaryOperator<Integer>
        // Because of Integer wrapper boxing and unboxing will happen.

        // ex.
        BinaryOperator<Integer> sumBinaryOperator1=(x,y) -> x+y; // Not efficient
        IntBinaryOperator intBinaryOperator=(x,y) -> x+y; // Internally it will use int (No wrapping)


        numbers.stream()
                .filter(integerPredicate)
                .map(integerIntegerFunction)
                .forEach(println);

    }
}
