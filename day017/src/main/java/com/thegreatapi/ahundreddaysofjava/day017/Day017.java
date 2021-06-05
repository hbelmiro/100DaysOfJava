package com.thegreatapi.ahundreddaysofjava.day017;

import java.util.regex.Pattern;

public class Day017 {

    private static final Pattern REGEX = Pattern.compile(", ");

    public static void main(String[] args) {
        System.out.println("Simple split: ");
        for (String column : simpleSplit()) {
            System.out.println(column);
        }

        System.out.println("Performant split: ");
        for (String column : performantSplit()) {
            System.out.println(column);
        }
    }

    private static String[] simpleSplit() {
        return "id, name, country, gender".split(", ");
    }

    // If you will split frequently, prefer this implementation.
    private static String[] performantSplit() {
        return REGEX.split("id, name, country, gender");
    }
}