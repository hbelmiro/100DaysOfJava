package com.thegreatapi.ahundreddaysofjava.day089;

class Person {

    private final String name;

    private final int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Maximum(17)
    public int getAge() {
        return age;
    }
}