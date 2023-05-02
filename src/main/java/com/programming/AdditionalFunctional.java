package com.programming;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class AdditionalFunctional {
    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring Boot","API","AWS","GCP","Docker","API","API");

        // Sorting

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out :: println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
        courses.stream().sorted(Comparator.reverseOrder()).distinct().forEach(System.out :: println);


        // Sorting Based on size
        courses.stream().sorted(Comparator.comparing(string -> string.length())).distinct().forEach(System.out :: println);

        //Create stream of numbers
        IntStream nums1=IntStream.range(1,10);
        nums1.forEach(System.out::println);

        IntStream nums2=IntStream.rangeClosed(1,10);
        nums2.forEach(System.out::println);

        System.out.println(IntStream.rangeClosed(1,10).sum());


        // Create Stream with condition
        System.out.println(IntStream.iterate(1,e->e+2).limit(10).peek(System.out::println).sum());

        System.out.println("____________");

        // create the stream of even numbers
        System.out.println(IntStream.iterate(1,e->e+1).limit(20).filter(value -> value%2==0).peek(System.out::println).sum());

        // Convert IntStream to List
        System.out.println(IntStream.iterate(1,e->e+1).limit(20).boxed().collect(Collectors.toList()));

        // Now for long range number
        System.out.println("IntStream "+IntStream.rangeClosed(1,10).reduce(1,(x,y)->x*y));
        System.out.println("LongStream "+ LongStream.rangeClosed(1,40).reduce(1,(x, y)->x*y));
        System.out.println("For BIG integer object "+ LongStream.rangeClosed(1,40).mapToObj(BigInteger::valueOf).reduce(BigInteger.ONE,BigInteger::multiply));

        // Combine all the list of courses separated by , or space ' '
        System.out.println("List of courses ::  "+courses.stream().collect(Collectors.joining(",")));

        // Now create Stream of Stream of array like [['s','p','r','i','n','g'],[...],[...]]
        // Here we need to use flatmap because alone map will not work map will retrun Stream.ReferencePipeline...
        // FlatMap : each element of Stream replaced with content of mapped stream (Array::stream)
        System.out.println("List of courses ::  "+courses.stream()
                .map(course->course.split(""))
                .flatMap(Arrays::stream).distinct().collect(Collectors.toList())
        );


        //The flatMap() operation has the effect of applying a one-to-many transformation to the elements of the stream,
        // and then flattening the resulting elements into a new stream.
        //Examples.
        //If orders is a stream of purchase orders, and each purchase order contains a collection of line items,
        // then the following produces a stream containing all the line items in all the orders:
        List<String> courses2=List.of("Spring","Spring Boot","API","AWS","GCP","Docker","API","API");
        // Join each of the element with another list element
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream()
                        .map(course2 -> List.of(course,course2)))
                .collect(Collectors.toList()));

        // Now eliminate same elements repeated twice
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream()
                        .map(course2 -> List.of(course,course2)))
                        .filter(list -> !list.get(0).equalsIgnoreCase(list.get(1)))
                .collect(Collectors.toList()));

        // Or based on course length
        System.out.println(courses.stream()
                .flatMap(course -> courses2.stream().filter(course2 -> course2.length()==course.length())
                        .map(course2 -> List.of(course,course2)))
                .filter(list -> !list.get(0).equalsIgnoreCase(list.get(1)))
                .collect(Collectors.toList()));
    }
}
