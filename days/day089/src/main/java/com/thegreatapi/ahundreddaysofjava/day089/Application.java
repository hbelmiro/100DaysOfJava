package com.thegreatapi.ahundreddaysofjava.day089;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
class Application {

    private final BeanValidator beanValidator;

    @Inject
    Application(BeanValidator beanValidator) {
        this.beanValidator = beanValidator;
    }

    public void run() {
        var p = new Person("Freddie", 58);
        beanValidator.validate(p);
    }
}