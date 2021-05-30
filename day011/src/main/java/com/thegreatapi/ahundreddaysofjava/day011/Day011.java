package com.thegreatapi.ahundreddaysofjava.day011;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

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
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        unsortedMap.forEach((key, value) -> treeMap.put(value, key));

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        treeMap.forEach((key, value) -> sortedMap.put(value, key));

        return Collections.unmodifiableMap(sortedMap);
    }
}