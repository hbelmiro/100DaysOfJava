package com.thegreatapi.ahundreddaysofjava.day041;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day041 {

    public static void main(String[] args) {
        List<String> originalList = new ArrayList<>();
        originalList.add("one");
        originalList.add("two");
        originalList.add("three");

        List<String> copy = Collections.unmodifiableList(originalList);

        originalList.remove("two");

        System.out.println(String.join(" ", copy));
    }
}