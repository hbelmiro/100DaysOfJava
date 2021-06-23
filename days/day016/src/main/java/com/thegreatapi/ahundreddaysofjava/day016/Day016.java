package com.thegreatapi.ahundreddaysofjava.day016;

public class Day016 {

    public static void main(String[] args) {
        System.out.println(createSql("id", "name", "coutry", "gender"));
    }

    private static String createSql(String... columns) {
        return new StringBuilder("SELECT ")
                .append(String.join(", ", columns))
                .append(" FROM PEOPLE")
                .toString();
    }
}