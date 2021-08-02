package com.thegreatapi.ahundreddaysofjava.day075;

class PaymentProcessorImpl implements PaymentProcessor {

    private final DependencyA dependencyA;

    private final DependencyB dependencyB;

    PaymentProcessorImpl(DependencyA dependencyA, DependencyB dependencyB) {
        this.dependencyA = dependencyA;
        this.dependencyB = dependencyB;
    }

    @Override
    public void process(Payment payment) {
        dependencyA.process();
        dependencyB.process();

        System.out.println("Finishing payment...");
    }
}
