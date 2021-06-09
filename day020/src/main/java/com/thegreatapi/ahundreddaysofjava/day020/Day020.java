package com.thegreatapi.ahundreddaysofjava.day020;

public class Day020 {

    public static void main(String[] args) {
        var original = "moc.ipataergeht";
        var reversed = new StringBuilder(original).reverse().toString();
        System.out.println(reversed);
    }
}