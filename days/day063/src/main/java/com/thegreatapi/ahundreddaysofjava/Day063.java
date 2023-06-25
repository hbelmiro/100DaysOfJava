package com.thegreatapi.ahundreddaysofjava;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Fallback;

import java.time.Instant;

@Path("/hello")
public class Day063 {

    @GET
    @Fallback(fallbackMethod = "fallbackHello")
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        if (Instant.now().toEpochMilli() % 2 == 0) {
            return "Hello from the main method";
        } else {
            throw new RuntimeException();
        }
    }

    public String fallbackHello() {
        return "Hello from the fallback method";
    }
}