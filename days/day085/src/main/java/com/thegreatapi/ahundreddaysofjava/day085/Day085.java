package com.thegreatapi.ahundreddaysofjava.day085;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Retry;

import java.security.SecureRandom;
import java.time.temporal.ChronoUnit;

@Path("/hello")
public class Day085 {

    private static final SecureRandom RANDOM = new SecureRandom();

    private static int numberOfAttempts;

    @GET
    @Retry(retryOn = MyCustomException.class, maxRetries = 3, delay = 2, delayUnit = ChronoUnit.SECONDS)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        numberOfAttempts++;

        if (numberOfAttempts < 3) {
            if (RANDOM.nextBoolean()) {
                // Will throw MyCustomException and will retry
                throw new MyCustomException();
            } else {
                // Will throw RuntimeException and won't retry
                throw new RuntimeException();
            }
        } else {
            return "Hello after " + numberOfAttempts + " attempts";
        }
    }

    static class MyCustomException extends RuntimeException {
        private static final long serialVersionUID = 6631584573985699096L;
    }
}