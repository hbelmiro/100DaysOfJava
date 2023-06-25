package com.thegreatapi.ahundreddaysofjava.day083;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.faulttolerance.Timeout;

import java.time.temporal.ChronoUnit;

@Path("/hello")
public class Day083 {

    @GET
    @Timeout(value = 1, unit = ChronoUnit.SECONDS)
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() throws InterruptedException {
        Thread.sleep(1500);
        return "";
    }
}