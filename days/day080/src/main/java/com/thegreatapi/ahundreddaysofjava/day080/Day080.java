package com.thegreatapi.ahundreddaysofjava.day080;

public class Day080 {

    private sealed interface Animal permits Dog, Cat {
        void speak();
    }

    private static non-sealed class Dog implements Animal {

        @Override
        public void speak() {
            System.out.println("Woof");
        }
    }

    private static final class Cat implements Animal {

        @Override
        public void speak() {
            System.out.println("Meow");
        }
    }

//    Bird is not allowed in the sealed hierarchy
//    private static class Bird implements Animal {
//
//        @Override
//        public void speak() {
//            System.out.println("Pew");
//        }
//    }
}