package com.programming;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

class Course {
    private String name;
    private String category;
    private int reviewScore;
    private int numberOfStudent;

    public Course(String name, String category, int reviewScore, int numberOfStudent) {
        this.name = name;
        this.category = category;
        this.reviewScore = reviewScore;
        this.numberOfStudent = numberOfStudent;
    }

    @Override
    public String toString() {
        return "[" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", reviewScore=" + reviewScore +
                ", numberOfStudent=" + numberOfStudent +
                ']';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getReviewScore() {
        return reviewScore;
    }

    public void setReviewScore(int reviewScore) {
        this.reviewScore = reviewScore;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

    public void setNumberOfStudent(int numberOfStudent) {
        this.numberOfStudent = numberOfStudent;
    }
}

public class CustomClass04 {
    public static void main(String[] args) {
      List<Course> courses=List.of(
                new Course("Spring","Framework",99,21000),
                new Course("Spring Boot","Framework",91,21000),
                new Course("java","Programming",90,10000),
                new Course("python","Programming",94,20000),
                new Course("C","Programming",92,22000),
                new Course("kafka","Framework",99,20000),
                new Course("Docker","Cloud",98,20000),
                new Course("API","Microservices",97,10000),
                new Course("Microservices","Microservices",99,25000),
                new Course("Azure","Cloud",98,12000),
                new Course("Gcp","Cloud",93,14000),
                new Course("Kubernetes","Cloud",92,100)
        );

      //allMatch , noneMatch, anyMatch

        Predicate<Course> reviewScoreGreaterThan80Predicate
                = course -> course.getReviewScore() > 80;
        Predicate<Course> reviewScoreGreaterThan100Predicate
                = course -> course.getReviewScore() > 100;

        Predicate<Course> reviewScoreGreaterThan90Predicate
                = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream()
                .allMatch(reviewScoreGreaterThan80Predicate));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreGreaterThan100Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan90Predicate));

        Comparator<Course> comparingByNoOfStudent=Comparator.comparing(Course :: getNumberOfStudent);

        System.out.println(courses.stream()
                .sorted(comparingByNoOfStudent).collect(Collectors.toList()));

        // or
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getCategory)).collect(Collectors.toList()));

        // Now in decreasing order
        System.out.println(courses.stream()
                .sorted(Comparator.comparing(Course::getCategory).reversed()).collect(Collectors.toList()));

        // Now primitive comparison operators with comparingInt
        System.out.println(courses.stream()
                .sorted(Comparator.comparingInt(Course::getNumberOfStudent)).collect(Collectors.toList()));

        // Now if we want to pick only top 2 results, Need to use limit
        System.out.println(courses.stream()
                .sorted(Comparator.comparingInt(Course::getNumberOfStudent))
                .limit(2)
                .collect(Collectors.toList()));

        // Now if we want to skip top 5 results ? Need to use skip
        System.out.println(courses.stream()
                .sorted(Comparator.comparingInt(Course::getNumberOfStudent))
                .skip(5)
                .collect(Collectors.toList()));

        // Now we can combine them

        System.out.println(courses.stream()
                .sorted(Comparator.comparingInt(Course::getNumberOfStudent))
                .skip(3)
                .limit(2)
                .collect(Collectors.toList()));


        // Now return if one of the result does not qualify the criteria (like break)
        System.out.println(courses.stream()
                .takeWhile(course -> course.getReviewScore()>=90)//if only one course failed the criteria just return
                .collect(Collectors.toList()));

        // Opposite to this it will keep checking if condition is true
        System.out.println(courses.stream()
                .dropWhile(course -> course.getReviewScore()>=95)//it will keep dropping until the criteria failed
                .collect(Collectors.toList()));

        // Now top or bottom results

        System.out.println("MAX: "+courses.stream()
                .max(Comparator.comparing(Course::getReviewScore)));
        System.out.println("MIN: "+courses.stream()
                .min(Comparator.comparing(Course::getReviewScore)));


        // Now condition is not matching but we want to return default value need to use orElse
        System.out.println(courses.stream()
                .filter(course -> course.getNumberOfStudent()>26000)
                .min(Comparator.comparing(course -> course.getReviewScore()>100))//Optional.empty
                .orElse(new Course("Default","Default",100,15000)));

        // findFirst, Will return Optional.empty
        System.out.println(courses.stream()
                .filter(course -> course.getNumberOfStudent()>26000)
                .findFirst());

        // findFirst will return first result that qualified the criteria
        System.out.println(courses.stream()
                .filter(course -> course.getNumberOfStudent()>20000)
                .findFirst());

        // findAny will return Any result which qualified the criteria
        //The behavior of this operation is explicitly nondeterministic; it is free to select any element in the stream.
        // This is to allow for maximal performance in parallel operations; the cost is that multiple invocations on the same source may not return the same result.
        // (If a stable result is desired, use findFirst() instead.)
        System.out.println(courses.stream()
                .filter(course -> course.getNumberOfStudent()>20000)
                .findAny());


        // Find total number of student which present in such courses

        System.out.println("Total number of student: "+
                courses.stream()
                        .filter(reviewScoreGreaterThan80Predicate)
                        .mapToInt(value -> value.getNumberOfStudent())
                        .reduce((left, right) -> left+right)
        );

        System.out.println("Total number of student with sum method: "+
                courses.stream()
                        .filter(reviewScoreGreaterThan80Predicate)
                        .mapToInt(Course::getNumberOfStudent)
                        .sum()
        );

        // Now find average

        System.out.println("Average number of student with average method: "+
                courses.stream()
                        .filter(reviewScoreGreaterThan80Predicate)
                        .mapToInt(Course::getNumberOfStudent)
                        .average()
        );

        // find number of courses
        System.out.println("Number of courses: "+
                courses.stream()
                        .filter(reviewScoreGreaterThan80Predicate)
                        .mapToInt(Course::getNumberOfStudent)
                        .count()
        );



        // Group these courses based on categories
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory)));

        // Now create a map with key as categories and value as count
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,Collectors.counting()))
                );

        //Now get the course with the highest ReviewScore
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory,
                        Collectors.maxBy(Comparator.comparing(Course::getReviewScore))))
        );

        //Now map the name of the course
        System.out.println(courses.stream()
                .collect(Collectors.groupingBy(Course::getCategory, Collectors.mapping(Course::getName, Collectors.toList()))));
        //{Cloud=[Docker, Azure, Gcp, Kubernetes], Programming=[java, python, C], Microservices=[API, Microservices], Framework=[Spring, Spring Boot, kafka]}

    }
}
