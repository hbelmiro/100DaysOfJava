package com.thegreatapi.ahundreddaysofjava.day072.calculator;

import jakarta.inject.Named;

@Named("Dog")
class Dog implements Animal {

    private Dog() {
    }

    @Override
    public String speak() {
        return "woof";
    }
}