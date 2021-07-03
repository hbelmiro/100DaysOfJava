package com.thegreatapi.ahundreddaysofjava.day045;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Day045 {

    public static void main(String[] args) {
        List<Musician> queen = getMusicians();

        // Instead of doing:
        queen.sort(new Comparator<Musician>() {
            @Override
            public int compare(Musician m1, Musician m2) {
                return m1.dateOfBirth.compareTo(m2.dateOfBirth);
            }
        });

        System.out.println(queen);

        // Just do:
        queen.sort(Comparator.comparing(Musician::dateOfBirth));

        System.out.println(queen);
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