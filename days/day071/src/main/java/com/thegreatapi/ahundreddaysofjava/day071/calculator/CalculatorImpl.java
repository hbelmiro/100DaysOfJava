package com.thegreatapi.ahundreddaysofjava.day071.calculator;

class CalculatorImpl implements Calculator {

    private CalculatorImpl() {
    }

    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}