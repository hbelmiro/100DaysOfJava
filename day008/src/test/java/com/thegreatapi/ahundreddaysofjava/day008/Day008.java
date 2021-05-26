package com.thegreatapi.ahundreddaysofjava.day008;

import java.text.MessageFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Day008 {

    private static final Logger LOGGER = Logger.getLogger(Day008.class.getName());

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        LOGGER.info("Starting tasks submissions");
        try {
            for (int i = 1; i <= 10; i++) {
//                LOGGER.info(MessageFormat.format());
                executor.submit(() -> task());
            }
        } finally {
            executor.shutdown();
        }
    }

    private static void task() {
    }
}
