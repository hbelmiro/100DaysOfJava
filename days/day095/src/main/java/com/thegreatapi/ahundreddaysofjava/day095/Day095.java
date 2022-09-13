package com.thegreatapi.ahundreddaysofjava.day095;


import net.datafaker.Faker;

import java.util.Date;
import java.util.List;
import java.util.stream.IntStream;

public class Day095 {

    private static final Faker FAKER = new Faker();

    public static void main(String[] args) {
        List<Person> people = IntStream.rangeClosed(1, 10)
                                       .mapToObj(i -> createPerson())
                                       .toList();

        people.forEach(System.out::println);

//        Person[firstName=Randall, lastName=Oberbrunner, dateOfBirth=Tue Oct 02 06:16:54 BRT 1962]
//        Person[firstName=Thanh, lastName=Lemke, dateOfBirth=Fri Feb 28 10:54:57 BRST 1964]
//        Person[firstName=Walker, lastName=Waters, dateOfBirth=Fri Feb 21 16:55:01 BRT 1992]
//        Person[firstName=Colin, lastName=Koelpin, dateOfBirth=Wed Jul 28 15:03:17 BRT 1982]
//        Person[firstName=Velia, lastName=Corwin, dateOfBirth=Thu Nov 07 06:41:49 BRT 1974]
//        Person[firstName=Dwayne, lastName=Wilkinson, dateOfBirth=Mon Apr 24 16:38:56 BRT 1972]
//        Person[firstName=Lynn, lastName=Oberbrunner, dateOfBirth=Tue Mar 11 09:29:37 BRT 2003]
//        Person[firstName=Cristie, lastName=Yundt, dateOfBirth=Thu Sep 04 05:28:06 BRT 1980]
//        Person[firstName=Brynn, lastName=Tremblay, dateOfBirth=Thu Nov 03 10:28:57 BRST 1988]
//        Person[firstName=Ahmad, lastName=Homenick, dateOfBirth=Tue Apr 19 15:46:28 BRT 1977]

//        or another way to do the same
        people = FAKER.<Person>collection().suppliers(Day095::createPerson).len(10).generate();
        people.forEach(System.out::println);
    }

    private static Person createPerson() {
        return new Person(
                FAKER.name().firstName(),
                FAKER.name().lastName(),
                FAKER.date().birthday()
        );
    }

    static record Person(String firstName, String lastName, Date dateOfBirth) {
    }
}