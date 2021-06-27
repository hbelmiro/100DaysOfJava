package com.thegreatapi.ahundreddaysofjava.day039;

public class Day039 {

    public static void main(String[] args) {
        int i = 4;
        int j = 21;

        int k = ++i * 7 + 2 - j--;

        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }
}