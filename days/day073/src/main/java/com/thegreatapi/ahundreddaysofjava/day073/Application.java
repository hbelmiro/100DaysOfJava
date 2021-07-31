package com.thegreatapi.ahundreddaysofjava.day073;

import com.thegreatapi.ahundreddaysofjava.day073.paymentprocessor.Asynchronous;
import com.thegreatapi.ahundreddaysofjava.day073.paymentprocessor.Payment;
import com.thegreatapi.ahundreddaysofjava.day073.paymentprocessor.PaymentProcessor;
import jakarta.inject.Inject;

import java.math.BigDecimal;

class Application {

    private final PaymentProcessor paymentProcessor;

    @Inject
    private Application(@Asynchronous PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void run() {
        paymentProcessor.process(new Payment("1234", BigDecimal.TEN));
    }
}