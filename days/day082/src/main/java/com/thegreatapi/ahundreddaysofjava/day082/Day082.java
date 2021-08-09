package com.thegreatapi.ahundreddaysofjava.day082;

public class Day082 {

    public static void main(String[] args) {
        int a = 2;
        int b = Integer.MAX_VALUE;

        long uncastedLong = a * b;
        System.out.println(uncastedLong); // Prints: -2

        long castedLong = (long) a * b;
        System.out.println(castedLong); // Prints: 4294967294
    }
}