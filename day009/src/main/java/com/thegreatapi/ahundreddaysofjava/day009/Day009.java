package com.thegreatapi.ahundreddaysofjava.day009;

public class Day009 {

    public static void main(String[] args) {
        for (Gender gender : Gender.values()) {
            System.out.printf("The value of %s is %s%n", gender, gender.getValue());
        }
    }

    public enum Gender {
        FEMALE('f'),
        MALE('m');

        private final char value;

        Gender(char value) {
            this.value = value;
        }

        public char getValue() {
            return value;
        }
    }
}
