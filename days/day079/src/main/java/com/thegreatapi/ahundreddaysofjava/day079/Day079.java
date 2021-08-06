package com.thegreatapi.ahundreddaysofjava.day079;

import com.thegreatapi.ahundreddaysofjava.day079.myservice.MyService;
import com.thegreatapi.ahundreddaysofjava.day079.myservice.MyServiceFactory;

public class Day079 {

    public static void main(String[] args) {
        // This class has access to MyService and MyServiceFactory, but not MyServiceImpl
        MyService myService = MyServiceFactory.createMyService();
        myService.run();
    }
}