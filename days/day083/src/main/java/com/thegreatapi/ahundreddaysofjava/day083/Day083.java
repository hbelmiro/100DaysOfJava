package com.thegreatapi.ahundreddaysofjava.day083;

import org.eclipse.microprofile.faulttolerance.Timeout;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
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