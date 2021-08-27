package com.thegreatapi.ahundreddaysofjava.day100;

import org.openjdk.jmh.annotations.Benchmark;

public class Day100 {

    @Benchmark
    public void benchmarkNullable(ExecutionPlan plan) {
        for (var i = 0; i < ExecutionPlan.ITERACTIONS; i++) {
            String value = plan.getMyService().getNullable(i);
            if (value != null) {
                System.out.println(i + ": " + value);
            }
        }
    }

    @Benchmark
    public void benchmarkOptional(ExecutionPlan plan) {
        for (var i = 0; i < ExecutionPlan.ITERACTIONS; i++) {
            var finalI = i;
            plan.getMyService().getWithOptional(i).ifPresent(value -> System.out.println(finalI + ": " + value));
        }
    }
}