package com.thegreatapi.ahundreddaysofjava.day035;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day035 {

    public static void main(String[] args) throws IOException {
        String path = args[0];

        // Instead of doing:
        var bufferedReader = new BufferedReader(new FileReader(path));
        try {
            String line = bufferedReader.readLine();
            System.out.println(line);
        } finally {
            bufferedReader.close();
        }

        // Just do:
        try (var autoClosedBufferedReader = new BufferedReader(new FileReader(path))) {
            String line = autoClosedBufferedReader.readLine();
            System.out.println(line);
        }
    }
}