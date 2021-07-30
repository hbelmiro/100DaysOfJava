package com.thegreatapi.ahundreddaysofjava.day072.calculator;

import jakarta.inject.Named;

@Named("Cat")
class Cat implements Animal {

    private Cat(){
    }

    @Override
    public String speak() {
        return "meow";
    }
}