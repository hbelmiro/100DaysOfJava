package com.thegreatapi.ahundreddaysofjava.day066;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

@SuppressWarnings({"ClassCanBeRecord", "unused"})
public class Day066 {

    // Instead of doing:

    @AllArgsConstructor
    @ToString
    @EqualsAndHashCode
    class PersonLombok {
        @Getter
        private final String name;
        @Getter
        private final LocalDate dateOfBirth;
        @Getter
        private final String country;
    }

    // Just do: (requires JDK 16)

    record PersonPureJava(String name, LocalDate dateOfBirth, String country) {
    }
}