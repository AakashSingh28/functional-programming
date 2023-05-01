package com.programming;

import java.util.List;
import java.util.function.Supplier;

@SuppressWarnings("unused")
public class MethodReferences03 {
    public static void main(String[] args) {

        List<String> courses=List.of("Spring","Spring Boot","API","AWS","GCP","Docker");

        courses.stream()
                .map(str->str.toUpperCase())
                .forEach(System.out::println);

        // Or

        courses.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);

        // Constructor Reference
        Supplier<String> supplier=()->new String();
        //or
        Supplier<String> SupplierReference=String::new;

    }
}
