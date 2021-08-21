package com.thegreatapi.ahundreddaysofjava.day094;

import java.util.List;
import java.util.concurrent.Flow;
import java.util.concurrent.SubmissionPublisher;

public class Day094 {

    public static void main(String[] args) {
        List<String> judasPriestMembers = List.of(
                "Rob Halford",
                "K.K. Downing",
                "Glenn Tipton",
                "Ian Hill",
                "Scott Travis"
        );

        var subscriber = new MySubscriber();

        try (var publisher = new SubmissionPublisher<String>()) {
            publisher.subscribe(subscriber);
            judasPriestMembers.forEach(publisher::submit);
        }
    }

    static class MySubscriber implements Flow.Subscriber<String> {

        private Flow.Subscription subscription;

        @Override
        public void onSubscribe(Flow.Subscription subscription) {
            System.out.println("Started subscription");
            this.subscription = subscription;
            subscription.request(1);
        }

        @Override
        public void onNext(String item) {
            System.out.println(item);
            subscription.request(1);
        }

        @Override
        public void onError(Throwable throwable) {
            System.err.println("Error: " + throwable);
        }

        @Override
        public void onComplete() {
            System.out.println("Subscription complete");
        }
    }
}