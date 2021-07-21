package com.thegreatapi.ahundreddaysofjava;

import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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