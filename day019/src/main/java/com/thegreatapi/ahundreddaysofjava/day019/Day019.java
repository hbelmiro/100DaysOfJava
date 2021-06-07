package com.thegreatapi.ahundreddaysofjava.day019;

import java.util.LinkedHashMap;
import java.util.Map;

public class Day019 {

    public static void main(String[] args) {
        Map<Integer, String> map = new LinkedHashMap<>();

        map.put(5, "five");
        map.put(4, "four");
        map.put(3, "three");
        map.put(2, "two");
        map.put(1, "one");

        map.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
