package com.thegreatapi.ahundreddaysofjava.day096;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

@ApplicationScoped
public class AfterOrderCompletesObserver {

    public void observeAfterOrderCompletesMessage(@Observes @AfterOrderCompletes Order order){
        System.out.printf("Order %s was completed.%n", order);
    }
}