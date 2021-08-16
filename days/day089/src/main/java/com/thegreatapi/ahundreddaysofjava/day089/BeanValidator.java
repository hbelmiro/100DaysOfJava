package com.thegreatapi.ahundreddaysofjava.day089;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.Arrays;

@ApplicationScoped
class BeanValidator {

    private final MethodValidator methodValidator;

    @Inject
    BeanValidator(MethodValidator methodValidator) {
        this.methodValidator = methodValidator;
    }

    void validate(Object o) {
        Arrays.stream(o.getClass().getDeclaredMethods())
              .filter(method -> method.isAnnotationPresent(Maximum.class))
              .forEach(method -> methodValidator.validate(method, o));
    }
}