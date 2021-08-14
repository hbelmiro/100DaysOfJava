package com.thegreatapi.ahundreddaysofjava.day087;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Day087 {

    public static void main(String[] args) {
        var myAnnotatedObject = new AnnotatedClass();
        var myNonAnnotatedObject = new NonAnnotatedClass();

        System.out.println(isAnnotated(myAnnotatedObject));   // Prints: true
        System.out.println(isAnnotated(myNonAnnotatedObject)); // Prints: false
    }

    private static boolean isAnnotated(Object object) {
        return object.getClass().isAnnotationPresent(MyAnnotation.class);
    }

    @MyAnnotation
    static class AnnotatedClass {
    }

    static class NonAnnotatedClass {
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface MyAnnotation {
    }
}