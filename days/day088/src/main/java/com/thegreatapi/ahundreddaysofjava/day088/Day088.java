package com.thegreatapi.ahundreddaysofjava.day088;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class Day088 {

    public static void main(String[] args) throws NoSuchFieldException {
        var myObject = new MyClass(2021, 8);

        System.out.println(isAnnotated(myObject, "year"));   // Prints: true
        System.out.println(isAnnotated(myObject, "month"));   // Prints: true
    }

    private static boolean isAnnotated(Object object, String fieldName) throws NoSuchFieldException {
        return object.getClass().getDeclaredField(fieldName).isAnnotationPresent(MyAnnotation.class);
    }

    static class MyClass {

        @MyAnnotation
        private final int year;

        private final int month;

        MyClass(int year, int month) {
            this.year = year;
            this.month = month;
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface MyAnnotation {
    }
}