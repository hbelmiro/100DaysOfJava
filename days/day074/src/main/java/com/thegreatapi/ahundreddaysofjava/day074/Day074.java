package com.thegreatapi.ahundreddaysofjava.day074;

import java.util.function.Consumer;

public class Day074 {

    public static void main(String[] args) {
        Person daveMustaine = new Person("Dave Mustaine", "Megadeth");

        // A consumer is a Function that uses an argument and returns nothing. Like Function<Person, Void>.
        Consumer<Person> personConsumer = person -> System.out.printf(
                "%s from %s sings: %s%n", daveMustaine.name, daveMustaine.bandName, "\"Holy waaaars\""
        );

        daveMustaine.sing(personConsumer);
    }

    private static record Person(String name, String bandName) {

        void sing(Consumer<Person> consumer) {
            consumer.accept(this);
        }
    }
}