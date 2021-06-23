package com.thegreatapi.ahundreddaysofjava.day029;

import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.IntStream;

public class Day029 {

    private final Map<Integer, Integer> primes = new ConcurrentHashMap<>();

    public void startComputingPrimes() {
        var count = 0;
        for (var i = 2; i <= Integer.MAX_VALUE; i++) {
            if (isPrime(i)) {
                primes.put(++count, i);
            }
        }
    }

    private static boolean isPrime(int number) {
        return IntStream.rangeClosed(2, (int) Math.sqrt(number))
                        .allMatch(n -> number % n != 0);
    }

    public Map<Integer, Integer> getAlreadyComputedPrimes() {
        return Collections.unmodifiableMap(primes);
    }
}
