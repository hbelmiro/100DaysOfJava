package com.thegreatapi.ahundreddaysofjava.day070;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Day070 {

    record Person(String name, LocalDate dateOfBirth) {

        public boolean isYearsHigherThan(int years) {
            return Period.between(dateOfBirth, LocalDate.now()).get(ChronoUnit.YEARS) >= years;
        }
    }
}