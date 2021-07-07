package com.thegreatapi.ahundreddaysofjava.day049;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Day049 {

    public static void main(String[] args) {
        Map<Integer, String> portugueseNumbers = translateToPortuguese(englishNumbers());
        System.out.println(portugueseNumbers);
    }

    private static Map<Integer, String> translateToPortuguese(Map<Integer, String> numbers) {
        /*
        Instead of doing:
        Function<Integer, Integer> keyMapper = number -> number;
         */

        // Just do:
        Function<Integer, Integer> keyMapper = Function.identity();

        Function<Integer, String> valueMapper = number -> switch (number) {
            case 1 -> "um";
            case 2 -> "dois";
            case 3 -> "três";
            case 4 -> "quatro";
            default -> throw new UnsupportedOperationException("Cannot translate %d".formatted(number));
        };

        return numbers.keySet()
                      .stream()
                      .collect(Collectors.toMap(keyMapper, valueMapper));
    }

    private static Map<Integer, String> englishNumbers() {
        return Map.of(
                1, "one",
                2, "two",
                3, "three",
                4, "four"
        );
    }
}