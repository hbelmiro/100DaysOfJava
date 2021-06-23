package com.thegreatapi.ahundreddaysofjava.day034;

import java.io.File;

public class Day034 {

    public static final String JAVA_SUFFIX = File.separator + "java";

    public static void main(String[] args) {
        ProcessHandle.allProcesses()
                     .filter(Day034::isJavaProcess)
                     .map(ProcessHandle::info)
                     .forEach(System.out::println);
    }

    private static boolean isJavaProcess(ProcessHandle processHandle) {
        return processHandle.info()
                            .command()
                            .map(command -> command.endsWith(JAVA_SUFFIX))
                            .orElse(false);
    }
}
