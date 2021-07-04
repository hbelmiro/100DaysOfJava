package com.thegreatapi.ahundreddaysofjava.day046;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Day046 {

    public static void main(String[] args) {
        List<Musician> queen = getMusicians();
        List<Integer> years;

        // Instead of doing:
        years = new ArrayList<>();
        for (Musician musician : queen) {
            years.add(musician.dateOfBirth.getYear());
        }

        System.out.println(years);

        // Just do:
        years = queen.stream()
                     .map(musician -> musician.dateOfBirth.getYear())
                     .collect(Collectors.toList());

        System.out.println(years);
    }

    private static List<Musician> getMusicians() {
        Musician roger = new Musician("Roger Taylor", LocalDate.of(1949, 7, 26));
        Musician john = new Musician("John Deacon", LocalDate.of(1951, 8, 19));
        Musician brian = new Musician("Brian May", LocalDate.of(1947, 7, 19));
        Musician freddie = new Musician("Freddie Mercury", LocalDate.of(1946, 9, 5));

        return Arrays.asList(roger, john, brian, freddie);
    }

    record Musician(String name, LocalDate dateOfBirth) {
    }
}