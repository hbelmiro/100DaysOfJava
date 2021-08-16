package com.thegreatapi.ahundreddaysofjava.day089;

import jakarta.enterprise.context.ApplicationScoped;

import java.lang.reflect.Method;

@ApplicationScoped
class MethodValidator {

    void validate(Method method, Object object) {
        Object value;
        try {
            value = method.invoke(object);
        } catch (ReflectiveOperationException e) {
            throw new RuntimeException(e);
        }

        int maximum = method.getAnnotation(Maximum.class).value();

        if (value instanceof Integer number && number > maximum) {
            throw new RuntimeException("Invalid object. Method " + method.getName() +
                    " can't return a value greater than " + maximum);
        }
    }
}