package com.thegreatapi.ahundreddaysofjava.day098;

import jakarta.annotation.Priority;
import jakarta.inject.Inject;
import jakarta.interceptor.AroundInvoke;
import jakarta.interceptor.Interceptor;
import jakarta.interceptor.InvocationContext;

@Interceptor
@Validate
@Priority(1)
public class ValidationInterceptor {

    private final EmailValidator emailValidator;

    @Inject
    public ValidationInterceptor(EmailValidator emailValidator) {
        this.emailValidator = emailValidator;
    }

    @AroundInvoke
    public Object intercept(InvocationContext invocationContext) throws Exception {
        for (var i = 0; i < invocationContext.getParameters().length; i++) {
            if (invocationContext.getMethod().getParameters()[i].isAnnotationPresent(Email.class)
                    && invocationContext.getParameters()[i] instanceof String email) {
                emailValidator.validate(email);
            }
        }

        return invocationContext.proceed();
    }
}