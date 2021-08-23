package com.thegreatapi.ahundreddaysofjava.day096;

import jakarta.inject.Inject;

import java.math.BigDecimal;
import java.util.List;

public class Application {

    private final OrderService orderService;

    @Inject
    public Application(OrderService orderService) {
        this.orderService = orderService;
    }

    public void run() {
        var order = new Order("Helber", List.of("Pencil", "Book", "Rubber"), new BigDecimal("95.49"));
        orderService.complete(order);
    }
}