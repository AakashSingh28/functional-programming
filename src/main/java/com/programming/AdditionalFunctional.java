package com.programming;

import java.util.Comparator;
import java.util.List;

public class AdditionalFunctional {
    public static void main(String[] args) {
        List<String> courses=List.of("Spring","Spring Boot","API","AWS","GCP","Docker","API","API");

        // Sorting

        courses.stream().sorted(Comparator.naturalOrder()).forEach(System.out :: println);
        courses.stream().sorted(Comparator.reverseOrder()).forEach(System.out :: println);
        courses.stream().sorted(Comparator.reverseOrder()).distinct().forEach(System.out :: println);


        // Sorting Based on size
        courses.stream().sorted(Comparator.comparing(string -> string.length())).distinct().forEach(System.out :: println);
    }
}
