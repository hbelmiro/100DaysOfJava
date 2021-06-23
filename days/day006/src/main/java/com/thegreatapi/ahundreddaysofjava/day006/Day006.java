package com.thegreatapi.ahundreddaysofjava.day006;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ForkJoinPool;
import java.util.logging.Level;
import java.util.logging.Logger;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Day006 {

    private static final Logger LOGGER = Logger.getLogger(Day006.class.getName());

    public static void main(String[] args) {
        CompletableFuture.runAsync(Day006::task);

        LOGGER.info("Message from the main thread. Note that this message is logged before the async task ends.");

        LOGGER.info("Waiting for the async task to end.");
        boolean isQuiecent = ForkJoinPool.commonPool().awaitQuiescence(5, SECONDS);
        if (isQuiecent) {
            LOGGER.info("Async task ended.");
        } else {
            LOGGER.log(Level.SEVERE, "The async task is taking too long to finish. This program will end anyway.");
        }
    }

    private static void task() {
        LOGGER.info("Async task starting. This message is logged by the async task thread");
        try {
            Thread.sleep(1000);
            LOGGER.info("Async task is ending. This message is logged by the async task thread");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            LOGGER.log(Level.SEVERE, "The async task thread was interrupted.", e);
        }
    }
}
