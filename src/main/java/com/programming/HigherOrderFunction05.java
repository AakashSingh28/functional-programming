package com.programming;

import java.util.function.Predicate;

public class HigherOrderFunction05 {

    public static void main(String[] args) {


        Predicate<Course> reviewScoreGreaterThan80Predicate
                = createPredicateWithCutOffDate(95);
        Predicate<Course> reviewScoreGreaterThan100Predicate
                = createPredicateWithCutOffDate(90);


    }

    private static Predicate<Course> createPredicateWithCutOffDate(int cutOffReviewScore) {
        return course -> course.getReviewScore() > cutOffReviewScore;
    }
}
