package com.thegreatapi.ahundreddaysofjava.day098;

import jakarta.inject.Inject;

public class Application {

    private final MyService myService;

    @Inject
    public Application(MyService myService) {
        this.myService = myService;
    }

    public void run() {
        // Will throw: Exception in thread "main" java.lang.RuntimeException: The email helber @ not valid email is not valid.
        System.out.println(myService.hello("helber @ not valid email"));
    }
}