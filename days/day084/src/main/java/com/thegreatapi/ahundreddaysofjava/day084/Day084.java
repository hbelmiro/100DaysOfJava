package com.thegreatapi.ahundreddaysofjava.day084;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.time.temporal.ChronoUnit;

@Path("/hello")
public class Day084 {

    private static int numberOfAttempts;

    @GET
    @Retry(maxRetries = 3, delay = 2, delayUnit = ChronoUnit.SECONDS)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        numberOfAttempts++;

        if (numberOfAttempts < 3) {
            throw new RuntimeException("Emulates an error");
        } else {
            return "Hello after " + numberOfAttempts + " attempts";
        }
    }
}