package com.thegreatapi.ahundreddaysofjava.day050;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Day050 {

    public static void main(String[] args) {
        System.out.println(createPool(10));
        System.out.println(enhancedCreatePool(10));
    }

    // Instead of:
    private static List<PooledObject> createPool(int poolSize) {
        List<PooledObject> pool = new ArrayList<>(poolSize);
        for (var i = 0; i < poolSize; i++) {
            pool.add(new PooledObject(String.valueOf(i)));
        }
        return pool;
    }

    // Just do:
    private static List<PooledObject> enhancedCreatePool(int poolSize) {
        return IntStream.range(0, poolSize)
                        .mapToObj(i -> new PooledObject(String.valueOf(i)))
                        .toList();
    }

    private record PooledObject(String id) {
    }
}