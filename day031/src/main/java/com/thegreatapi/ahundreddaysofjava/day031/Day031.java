package com.thegreatapi.ahundreddaysofjava.day031;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day031 {

    public static void main(String[] args) {
        // Instead of doing:
        List<String> list = Stream.of("the", "great", "api", ".com")
                                  .collect(Collectors.toList());

        // Just do:
        List<String> listJdk16 = Stream.of("the", "great", "api", ".com")
                                       .toList();
    }
}