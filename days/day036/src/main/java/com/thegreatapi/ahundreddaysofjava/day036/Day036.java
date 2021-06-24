package com.thegreatapi.ahundreddaysofjava.day036;

import javax.annotation.Nonnull;

public final class Day036 {

    private Day036() {
    }

    public static void main(String[] args) {
        printLenght(null);
    }

    public static void printLenght(@Nonnull String s) {
        System.out.println(s.length());
    }
}