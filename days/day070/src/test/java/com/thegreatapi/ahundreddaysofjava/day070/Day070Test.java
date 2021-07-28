package com.thegreatapi.ahundreddaysofjava.day070;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;
import java.util.stream.Stream;

import static com.thegreatapi.ahundreddaysofjava.day070.Day070.Person;
import static org.assertj.core.api.Assertions.assertThat;

class Day070Test {

    private static Stream<Arguments> isYearsHigherThanSource() {
        Person peter = new Person("Peter", LocalDate.of(1950, 1, 1));
        Person john = new Person("John", LocalDate.of(2015, 1, 1));
        Person mary = new Person("Mary", LocalDate.of(2003, 1, 1));

        return Stream.of(
                Arguments.of(peter, 18, true),
                Arguments.of(john, 18, false),
                Arguments.of(mary, 18, true)
        );
    }

    @ParameterizedTest
    @MethodSource("isYearsHigherThanSource")
    void isYearsHigherThan(Person person, int years, boolean expectedResult) {
        assertThat(person.isYearsHigherThan(years))
                .isEqualTo(expectedResult);
    }
}