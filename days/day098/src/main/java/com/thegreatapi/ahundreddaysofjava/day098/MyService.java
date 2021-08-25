package com.thegreatapi.ahundreddaysofjava.day098;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Validate
public class MyService {

    public String hello(@Email String email) {
        return "Hello " + email;
    }
}