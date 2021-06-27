package com.thegreatapi.ahundreddaysofjava.day038;

public class Operators {

    // i++ you read: use and then increment
    // ++i you read: increment and then use

    static int result;
    static int i;

    public static void main(String[] args) {
        System.out.println("Use and increment.");
        useAndIncrement();

        System.out.println("Increment and use.");
        incrementAndUse();
    }

    static void useAndIncrement() {
        resetVariables();

        // Use and then increment.
        result = i++;

        System.out.println(result); // Prints: 0
        System.out.println(i); // Prints: 1

        resetVariables();

        // This is the same as:

        // Use
        result = i;

        // And then increment
        i = i + 1;

        System.out.println(result); // Prints: 0
        System.out.println(i); // Prints: 1
    }

    private static void incrementAndUse() {
        resetVariables();

        // Increment and then use.
        result = ++i;

        System.out.println(result); // Prints: 1
        System.out.println(i); // Prints: 1

        resetVariables();

        // This is the same as:

        // Increment
        i = i + 1;

        // And then use
        result = i;

        System.out.println(result); // Prints: 1
        System.out.println(i); // Prints: 1
    }

    static void resetVariables() {
        result = 0;
        i = 0;
    }
}