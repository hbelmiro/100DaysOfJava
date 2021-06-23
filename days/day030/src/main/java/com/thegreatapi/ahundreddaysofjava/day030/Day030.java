package com.thegreatapi.ahundreddaysofjava.day030;

public class Day030 {

    public static void main(String[] args) {

        // Requires JDK 15 or JDK 13 with Preview Features enabled

        var myString = """
                This is a
                text block of
                multiple lines.
                """;

        System.out.println(myString);

        var myIndentedString = """
                And this is
                a text block with
                indentation:
                    public String getMessage() {
                         if (LocalTime.now().isAfter(LocalTime.of(12, 0))) {
                             return "Good afternoon";
                         } else {
                             return "Good morning";
                         }
                     }
                """;

        System.out.println(myIndentedString);
    }
}