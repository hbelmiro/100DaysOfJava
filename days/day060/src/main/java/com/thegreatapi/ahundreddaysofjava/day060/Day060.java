package com.thegreatapi.ahundreddaysofjava.day060;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Predicate.not;

public class Day060 {

    public static void main(String[] args) {
        Predicate<Integer> isEven = intValue -> intValue % 2 == 0;
        Predicate<Integer> isPositive = intValue -> intValue > 0;

        List<Integer> numbers = getNumbers();

        // Prints negative odd numbers and positive even numbers.
        numbers.stream()
               .filter(isEven.and(isPositive).or(not(isEven).and(not(isPositive))))
               .forEach(System.out::println);
    }

    private static List<Integer> getNumbers() {
        return IntStream.rangeClosed(-20, 20).boxed().collect(Collectors.toList());
    }
}