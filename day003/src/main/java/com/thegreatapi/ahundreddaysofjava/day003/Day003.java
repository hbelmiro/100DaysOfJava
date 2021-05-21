package com.thegreatapi.ahundreddaysofjava.day003;

import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Day003 {

    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();

    public static void main(String[] args) throws InterruptedException {
        var day003 = new Day003();
        day003.printCurrentTimeEvery2Seconds();
        Thread.sleep(15_000);
        day003.stopPrinting();
    }

    public void printCurrentTimeEvery2Seconds() {
        Runnable task = () -> System.out.println(LocalTime.now());
        scheduledExecutorService.scheduleAtFixedRate(task, 0, 2, TimeUnit.SECONDS);
    }

    public void stopPrinting() {
        scheduledExecutorService.shutdown();
    }

}
