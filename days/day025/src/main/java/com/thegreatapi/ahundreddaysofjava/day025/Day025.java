package com.thegreatapi.ahundreddaysofjava.day025;

public class Day025 {

    public static void main(String[] args) {
        Number n = 6;

        // Instead of doing:
        if (n instanceof Integer) {
            Integer i = (Integer) n;
            print(i);
        }

        // Just do:
        if (n instanceof Integer i) {
            print(i);
        }
    }

    private static void print(Integer i) {
        System.out.println(i);
    }
}
