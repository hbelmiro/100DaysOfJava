package com.thegreatapi.ahundreddaysofjava.day100;

import org.openjdk.jmh.annotations.Level;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.Setup;
import org.openjdk.jmh.annotations.State;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

@State(Scope.Benchmark)
public class ExecutionPlan {

    public static final int ITERACTIONS = 10_000;

    private MyService myService;

    @Setup(Level.Iteration)
    public void setUp() {
        myService = new MyService(createMap());
    }

    public MyService getMyService() {
        return myService;
    }

    private static Map<Integer, String> createMap() {
        Map<Integer, String> map = new TreeMap<>();
        for (var i = 0; i < ITERACTIONS; i++) {
            map.put(i, i % 2 == 0 ? "yes" : null);
        }
        return Collections.unmodifiableMap(map);
    }
}
