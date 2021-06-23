package com.thegreatapi.ahundreddaysofjava.day026;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Optional;

public class Day026 {

    public static void main(String[] args) {
        // Instead of doing:
        String nullableValue = getNullableValue();
        if (nullableValue != null) {
            System.out.println(nullableValue.length());
        } else {
            System.out.println(0);
        }

        // Just do:
        System.out.println(getOptionalValue().map(String::length).orElse(0));
    }

    @Nonnull
    private static Optional<String> getOptionalValue() {
        return Optional.empty();
    }

    @Nullable
    private static String getNullableValue() {
        return null;
    }
}