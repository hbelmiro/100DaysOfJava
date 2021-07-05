package com.thegreatapi.ahundreddaysofjava.day047;

public class Day047 {

    @FunctionalInterface
    interface Converter {
        // Because of the @FunctionalInterface annotation, only one method is allowed in this interface

        String convert(Integer number);
    }

    public static void main(String[] args) {
        for (var i = 1; i <= 4; i++) {
            System.out.println(i + " in english: " + englishConverter().convert(i));
            System.out.println(i + " in portuguese: " + portugueseConverter().convert(i));
            System.out.println(i + " in german: " + germanConverter().convert(i));
        }
    }

    private static Converter germanConverter() {
        return number -> {
            switch (number) {
                case 1:
                    return "eins";
                case 2:
                    return "zwei";
                case 3:
                    return "drei";
                case 4:
                    return "vier";
                default:
                    throw new UnsupportedOperationException();
            }
        };
    }

    private static Converter portugueseConverter() {
        return number -> {
            switch (number) {
                case 1:
                    return "um";
                case 2:
                    return "dois";
                case 3:
                    return "três";
                case 4:
                    return "quatro";
                default:
                    throw new UnsupportedOperationException();
            }
        };
    }

    private static Converter englishConverter() {
        return number -> {
            switch (number) {
                case 1:
                    return "one";
                case 2:
                    return "two";
                case 3:
                    return "three";
                case 4:
                    return "four";
                default:
                    throw new UnsupportedOperationException();
            }
        };
    }
}