package com.thegreatapi.ahundreddaysofjava.day099;

public class Day099 {

    public static void main(String[] args) {
        /*
        In Java, primitive variables (those of types int, byte, short, long, float, double, boolean, or char)
        store values, and object variables (all the others, like String, Integer, Person, MyCustomClass...)
        store pointers to the memory address where the object is stored.
         */

        // The variable 'i' stores the value 42
        int i = 42;

        // The variable 'ronnieJamesDio' stores the memory address whre the object 'new Person("Ronnie James Dio")'
        // is stored. It's a pointer
        Person ronnieJamesDio = new Person("Ronnie James Dio");

        doStuff(i); // Pass a copy of 'i' to 'doStuff'
        System.out.println(i); // Prints: 42

        doStuff(ronnieJamesDio); // Pass a copy of the memory address stored by 'ronnieJamesDio' to 'doStuff'
        System.out.println(ronnieJamesDio); // Prints: Person{name='Ronnie James Dio'}

        doStuffWithTheObject(ronnieJamesDio); // Pass a copy of the memory address stored by 'ronnieJamesDio' to 'doStuffWithTheObject'
        System.out.println(ronnieJamesDio); // Prints: Person{name='Cozy Powell'}
    }

    private static void doStuff(int n) {
        // 'n' is a copy of 'i'

        // This changes the value stored by 'n'
        n = 100;
    }

    private static void doStuff(Person p) {
        // p stores a copy of the memory address stored by the variable 'ronnieJamesDio' (a pointer).

        // when we assign a new object, actually we're assigning the memory address where this new object is stored.
        // We're assigning a new pointer.
        p = new Person("Cozy Powell");
    }

    private static void doStuffWithTheObject(Person p) {
        // p stores a copy of the memory address stored by the variable 'ronnieJamesDio' (a pointer).

        // We're modifying the attribute of the object stored in the memory address to where the variable p points
        p.name = "Cozy Powell";
    }

    private static class Person {
        private String name;

        Person(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
