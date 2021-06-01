package com.thegreatapi.ahundreddaysofjava.day013;

import java.util.logging.Logger;

public class Day013 {

    private static final Logger LOGGER = Logger.getLogger(Day013.class.getName());

    public static void main(String[] args) throws InterruptedException {
        LOGGER.info("Application started. Will wait 3 seconds.");
        Thread.sleep(3000);

        LOGGER.info("Will print the singleton class name.");
        LOGGER.info(MySingletonClass.class.getName());

        LOGGER.info("Will wait 3 seconds.");
        Thread.sleep(3000);

        LOGGER.info("Will get an instance of the singleton class.");
        MySingletonClass object = MySingletonClass.getInstance();
        LOGGER.info("Instance's creation DateTime: " + object.getCreationDateTime());
    }
}
