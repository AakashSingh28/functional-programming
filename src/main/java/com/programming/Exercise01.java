package com.programming;

import java.util.List;
import java.util.stream.Collectors;

public class Exercise01 {

    public static void main(String[] args) {
        List<Integer> numbers = List.of(1, 2, 3, 54, 62, 11, 44, 90);
        printOddNumbers(numbers);
        printQubesOfOddNumbers(numbers);

        List<String> courses=List.of("Spring","Spring Boot","API","AWS","GCP","Docker");
        printCourses(courses);
        printCoursesContainingSpring(courses);
        printCoursesWith4Letters(courses);
        printNumberOfCharactersInCourse(courses);

        //Create a List with lengths of all course titles
        List<Integer> list = createListWithCourseLengths(courses);
        list.stream().forEach(System.out :: println);
    }

    private static List<Integer> createListWithCourseLengths(List<String> courses) {
        return courses.stream()
                .map(s -> s.length())
                .collect(Collectors.toList());
    }

    private static void printNumberOfCharactersInCourse(List<String> courses) {
        courses.stream()
                .map(course -> course+" "+course.length())
                .forEach(System.out::println);
    }

    private static void printQubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(number -> number%2!=0)
                .map(number -> number*number*number)
                .forEach(System.out :: println);
    }

    private static void printCoursesWith4Letters(List<String> courses) {

        courses.stream()
                .filter(Exercise01 :: isHavingKLetters)
                .forEach(System.out::println);

        // Or

        courses.stream()
                .filter(course -> course.length()>=4)
                .forEach(System.out::println);
    }

    private static boolean isHavingKLetters(String course) {
       return course.length()>=4;
    }

    private static void printCoursesContainingSpring(List<String> courses) {

        courses.stream()
                .filter(course -> course.contains("Spring"))
                .forEach(System.out::println);

    }

    private static void printCourses(List<String> courses) {
        courses.stream()
                .forEach(System.out::println);
    }

    private static void printOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(integer -> integer%2!=0)
                .forEach(System.out ::println);
    }
}
