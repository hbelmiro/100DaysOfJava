package com.thegreatapi.ahundreddaysofjava.day053;

import java.util.logging.Logger;

public class Day053 {

    private static final Logger LOGGER = Logger.getLogger(Day053.class.getName());

    public static void main(String[] args) {
        // Instead of always running the expensive method
        // LOGGER.info(veryExpensiveStringCreation());

        // Pass the method reference so that it is called only when and if necessary
        LOGGER.info(Day053::veryExpensiveStringCreation);
    }

    private static String veryExpensiveStringCreation() {
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            //TODO: handle properly
        }
        return "thegreatapi.com";
    }
}