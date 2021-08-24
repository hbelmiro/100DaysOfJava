package com.thegreatapi.ahundreddaysofjava.day097;

import org.javamoney.moneta.Money;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class Day097 {

    public static void main(String[] args) {
        CurrencyUnit usd = Monetary.getCurrency("USD");

        var oneDollar = Money.of(1, usd);
        var fiftyCent = Money.of(0.5, usd);

        // Prints: USD 1.5
        System.out.println(oneDollar.add(fiftyCent));
    }
}