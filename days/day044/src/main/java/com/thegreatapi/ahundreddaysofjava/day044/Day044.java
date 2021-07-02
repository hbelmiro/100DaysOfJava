package com.thegreatapi.ahundreddaysofjava.day044;

public class Day044 {

    public static final String NAME = "Helber Belmiro";

    public static void main(String[] args) {
        String formattedString;

        // Instead of doing:
        formattedString = String.format("My name is %s", NAME);

        // Just do: (Requires JDK 15)
        formattedString = "My name is %s".formatted(NAME);

        System.out.println(formattedString);
    }
}