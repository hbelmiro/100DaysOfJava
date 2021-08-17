package com.thegreatapi.ahundreddaysofjava.day090;

import java.util.StringJoiner;

public class Day090 {

    public static void main(String[] args) {
        var stringJoiner = new StringJoiner(";");

        stringJoiner.add("this");
        stringJoiner.add("is");
        stringJoiner.add("a");
        stringJoiner.add("StringJoiner");

        stringJoiner.add("and")
                    .add("it")
                    .add("has")
                    .add("a")
                    .add("fluent")
                    .add("api");

        // Prints: this;is;a;StringJoiner;and;it;has;a;fluent;api
        System.out.println(stringJoiner);
    }
}