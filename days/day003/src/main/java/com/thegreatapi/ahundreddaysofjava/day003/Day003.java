package com.thegreatapi.ahundreddaysofjava.day003;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;

class Day003Test {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private ScheduledExecutorService scheduledExecutorService;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
        scheduledExecutorService.shutdownNow();
    }

    @Test
    void testPrintCurrentTimeEvery2Seconds() throws InterruptedException {
        Day003 day003 = new Day003();
        day003.printCurrentTimeEvery2Seconds();

        TimeUnit.SECONDS.sleep(6); // Wait for 6 seconds to capture output

        day003.stopPrinting();

        String[] lines = outputStreamCaptor.toString().trim().split("\\r?\\n");

        assertTrue(lines.length >= 2); // At least 2 lines should be printed
        assertTrue(LocalTime.parse(lines[0]).isBefore(LocalTime.parse(lines[1])));
    }
}
