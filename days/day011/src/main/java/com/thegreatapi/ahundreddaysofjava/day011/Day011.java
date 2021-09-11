package com.thegreatapi.ahundreddaysofjava.day011;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class Day011 {

    public static void main(String[] args) {
        Map<String, Integer> unsortedMap = Map.of(
                "three", 3,
                "one", 1,
                "four", 4,
                "five", 5,
                "two", 2
        );

        Map<String, Integer> sortedMap = sortByValue(unsortedMap);

        System.out.println(sortedMap);
    }

    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
        Map<String, Integer> sortedMap = new LinkedHashMap<>();

        unsortedMap.entrySet().stream()
                   .sorted(Map.Entry.comparingByValue())
                   .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return Collections.unmodifiableMap(sortedMap);
    }
}