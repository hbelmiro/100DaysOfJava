package com.thegreatapi.ahundreddaysofjava.day001;

import org.junit.jupiter.api.Test;

import java.security.SecureRandom;

import static org.assertj.core.api.Assertions.assertThat;

class Day001Test {

    public static final SecureRandom SECURE_RANDOM = new SecureRandom();

    private static int generateRandomNumberBetween(int minimum, int maximum) {
        return SECURE_RANDOM.nextInt(maximum - minimum) + minimum;
    }

    @Test
    void randomNumberBetween() {
        var minimum = 100;
        var maximum = 1000;

        int randomNumber = generateRandomNumberBetween(minimum, maximum);

        assertThat(randomNumber).isBetween(minimum, maximum);
    }
}