package com.thegreatapi.ahundreddaysofjava.day092;

import java.util.List;

public class Day092 {

    public static void main(String[] args) {
        List<Integer> integers = List.of(1, 2, 3, 4, 5);

        Integer sum = integers.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sum);
    }
}