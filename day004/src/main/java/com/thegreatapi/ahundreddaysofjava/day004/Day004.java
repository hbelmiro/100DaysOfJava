package com.thegreatapi.ahundreddaysofjava.day004;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Day004 {

    public static void main(String[] args) {
        List<Person> beatles = new ArrayList<>();
        beatles.add(new Person("1", "John Lennon", LocalDate.of(1940, 10, 9)));
        beatles.add(new Person("2", "Paul McCartney", LocalDate.of(1942, 6, 18)));
        beatles.add(new Person("3", "George Harrison", LocalDate.of(1943, 2, 25)));
        beatles.add(new Person("4", "Ringo Starr", LocalDate.of(1940, 7, 7)));

        removeItemUsingEquals(beatles);

        removeItemUsingAnSpecificFilter(beatles);

        System.out.println(beatles);
    }

    private static void removeItemUsingAnSpecificFilter(List<Person> beatles) {
        beatles.removeIf(person -> "George Harrison".equals(person.getName()));
    }

    private static void removeItemUsingEquals(List<Person> beatles) {
        var lennon = new Person("1", "John Lennon", LocalDate.of(1940, 10, 9));
        beatles.remove(lennon);
    }

    static class Person {

        private final String id;

        private final String name;

        private final LocalDate dateOfBirth;

        Person(String id, String name, LocalDate dateOfBirth) {
            this.id = id;
            this.name = name;
            this.dateOfBirth = dateOfBirth;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public LocalDate getDateOfBirth() {
            return dateOfBirth;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            var person = (Person) o;
            return Objects.equals(id, person.id) && Objects.equals(name, person.name) && Objects.equals(dateOfBirth, person.dateOfBirth);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, name, dateOfBirth);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

}
