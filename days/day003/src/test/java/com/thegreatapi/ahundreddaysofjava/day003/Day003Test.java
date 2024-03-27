package com.thegreatapi.ahundreddaysofjava.day003;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day003Test {

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    private final PrintStream standardOut = System.out;
    private ScheduledExecutorService scheduledExecutorService;
    private List<String> timeList;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
        timeList = new ArrayList<>();
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

        TimeUnit.SECONDS.sleep(6);

        day003.stopPrinting();

        String[] lines = outputStreamCaptor.toString().trim().split("\\r?\\n");

        assertEquals(3, lines.length);
        for (String line : lines) {
            timeList.add(line);
        }
        assertEquals(3, timeList.size());

        assertEquals(LocalTime.parse(timeList.get(0)).plusSeconds(2), LocalTime.parse(timeList.get(1)));
        assertEquals(LocalTime.parse(timeList.get(1)).plusSeconds(2), LocalTime.parse(timeList.get(2)));
    }
}
