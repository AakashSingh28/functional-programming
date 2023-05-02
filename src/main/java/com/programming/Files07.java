package com.programming;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class Files07 {
    public static void main(String[] args) throws IOException {

        Files.lines(Paths.get("file.txt"))
                .map(str -> str.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);

        // How to list all the available files
        Files.list(Paths.get("."))
                .filter(Files::isDirectory) //It will present only directories
                .forEach(System.out::println);

    }
}
