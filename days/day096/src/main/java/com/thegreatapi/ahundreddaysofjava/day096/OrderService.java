package com.thegreatapi.ahundreddaysofjava.day096;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;

@ApplicationScoped
class OrderService {

    @Inject
    @BeforeOrderCompletes
    private Event<Order> beforeOrderCompleteEvent;

    @Inject
    @AfterOrderCompletes
    private Event<Order> afterOrderCompleteEvent;

    public void complete(Order order) {
        beforeOrderCompleteEvent.fire(order);
        doComplete(order);
        afterOrderCompleteEvent.fire(order);
    }

    private static void doComplete(Order order) {
        System.out.printf("Completing order %s.%n", order);
    }
}