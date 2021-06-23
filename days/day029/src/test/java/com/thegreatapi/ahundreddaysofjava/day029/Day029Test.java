package com.thegreatapi.ahundreddaysofjava.day029;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CompletableFuture;

import static org.awaitility.Awaitility.await;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day029Test {

    @Test
    void test() {
        Day029 day029 = new Day029();

        CompletableFuture.runAsync(day029::startComputingPrimes);

        // Await until the already computed primes contain the key 100_000
        await().until(() -> day029.getAlreadyComputedPrimes().containsKey(100_000));

        assertEquals(1299709, day029.getAlreadyComputedPrimes().get(100_000));
    }
}