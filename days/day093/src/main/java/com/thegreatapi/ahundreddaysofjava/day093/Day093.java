package com.thegreatapi.ahundreddaysofjava.day093;

import java.time.Instant;
import java.time.temporal.ChronoField;
import java.util.List;

public class Day093 {

    public static void main(String[] args) {
        List<String> myList = getList();

//      If myList is null, a NullPointerException will be thrown
        for (String s : myList) {
            System.out.println(s);
        }
    }

    private static List<String> getList() {
        if (someCondition()) {
            return List.of("a", "b", "c");
        } else {
//          Instead of returning null
//          return null;

//          Return an empty list, so the caller don't need to check if the returned list is not null
            return List.of();
        }
    }

    private static boolean someCondition() {
        return Instant.now().get(ChronoField.MILLI_OF_SECOND) % 2 == 0;
    }
}