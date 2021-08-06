package com.thegreatapi.ahundreddaysofjava.day079.myservice;

public final class MyServiceFactory {

    private MyServiceFactory() {
    }

    public static MyService createMyService() {
        return new MyServiceImpl();
    }
}