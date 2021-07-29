package com.thegreatapi.ahundreddaysofjava.day071;

import com.thegreatapi.ahundreddaysofjava.day071.calculator.Calculator;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class Application {

    private final Calculator calculator;

    @Inject
    private Application(Calculator calculator) {
        this.calculator = calculator;
    }

    public void run() {
        System.out.println(calculator.sum(2, 3));
    }
}