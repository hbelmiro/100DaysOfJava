package com.thegreatapi.ahundreddaysofjava.day075;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Day075 {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        Application application = container.select(Application.class).getHandler().get();

        application.run();

        container.shutdown();
    }
}