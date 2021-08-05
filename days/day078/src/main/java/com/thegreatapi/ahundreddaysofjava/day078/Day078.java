package com.thegreatapi.ahundreddaysofjava.day078;

import java.util.List;
import java.util.function.Function;

public class Day078 {

    public static void main(String[] args) {
        String s = map(42, obj -> "The value is " + obj);
        System.out.println(s);

        List<String> list = map(new String[]{"a", "b", "c"}, List::of);
        System.out.println(list);
    }

    private static <T, R> R map(T input, Function<T, R> function) {
        return function.apply(input);
    }
}