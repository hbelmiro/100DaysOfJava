package com.thegreatapi.ahundreddaysofjava.day081;

import java.util.Collections;
import java.util.List;

public class Day081 {

    public static void main(String[] args) {
        List<Integer> list = List.of(6, 3, 1, 2, 4, 2, 5, 8, 4, 5, 3);
        int frequency = Collections.frequency(list, 4);
        System.out.println(frequency);
    }
}