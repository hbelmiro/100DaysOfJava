package com.thegreatapi.ahundreddaysofjava.day023;

import java.io.IOException;
import java.util.Properties;

public class Day023 {

    public static void main(String[] args) throws IOException {
        var properties = new Properties();
        try (var reader = Day023.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(reader);
        }
        System.out.println(properties);
    }
}