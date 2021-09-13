package com.thegreatapi.ahundreddaysofjava.day012;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.logging.Logger;

public class Day012 {

    private static final Logger LOGGER = Logger.getLogger(Day012.class.getName());

    public static void main(String[] args) throws InterruptedException {
        var executorService = Executors.newSingleThreadExecutor();

        try {
            Callable<Integer> callable = Day012::doALongCalculation;
            Future<Integer> future = executorService.submit(callable);

            doOtherThingWhileCalculating();

            LOGGER.info("Will get the calculated value. Note that the value will be got immediately");
            LOGGER.info("Calculated value: " + future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executorService.shutdown();
        }
    }

    private static int doALongCalculation() throws InterruptedException {
        Thread.sleep(5000L);
        return 42;
    }

    private static void doOtherThingWhileCalculating() throws InterruptedException {
        Thread.sleep(7000L);
    }
}