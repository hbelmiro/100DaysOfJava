package com.thegreatapi.ahundreddaysofjava.day024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.util.concurrent.TimeUnit.SECONDS;

public class Day024 {

    public static void main(String[] args) throws IOException, InterruptedException {
        var process = new ProcessBuilder("ls").start();
        try (var stdOutReader = new BufferedReader(new InputStreamReader(process.getInputStream()));
             var stdErrReader = new BufferedReader(new InputStreamReader(process.getErrorStream()))) {
            if (process.waitFor(5, SECONDS)) {
                int exitValue = process.exitValue();
                if (exitValue == 0) {
                    stdOutReader.lines().forEach(System.out::println);
                } else {
                    stdErrReader.lines().forEach(System.err::println);
                }
            } else {
                throw new RuntimeException("Timeout");
            }
        }
    }
}