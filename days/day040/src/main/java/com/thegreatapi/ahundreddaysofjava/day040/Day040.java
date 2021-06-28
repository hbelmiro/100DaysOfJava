package com.thegreatapi.ahundreddaysofjava.day040;

import java.util.function.Predicate;
import java.util.stream.Stream;

import static java.util.function.Predicate.not;

public class Day040 {

    public static void main(String[] args) {
        // Instead of doing:
        printAllThat(word -> !word.isEmpty());

        // Just do:
        printAllThat(not(String::isEmpty));
    }

    private static void printAllThat(Predicate<String> filter) {
        Stream.of("avocado", "chair", "", "dog", "car")
              .filter(filter)
              .forEach(System.out::println);
    }
}