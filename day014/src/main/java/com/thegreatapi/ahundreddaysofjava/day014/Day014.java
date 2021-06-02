package com.thegreatapi.ahundreddaysofjava.day014;

import java.math.BigDecimal;

public class Day014 {

    public static void main(String[] args) {
        // Prints 1.229999999999999982236431605997495353221893310546875
        System.out.println(new BigDecimal(1.23));

        // Prints 1.23
        System.out.println(new BigDecimal("1.23"));

        // Prints 1.23
        System.out.println(BigDecimal.valueOf(1.23));
    }
}