package com.thegreatapi.ahundreddaysofjava.day096;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class BeforeOrderCompletesObserver {

    public void observeBeforeOrderCompletesMessage(@Observes @BeforeOrderCompletes Order order){
        System.out.printf("Order %s will complete.%n", order);
    }
}