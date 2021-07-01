package com.thegreatapi.ahundreddaysofjava.day043;

public class Day043 {

    public static void main(String[] args) {
        var methodCode = """
                private static void task() {
                    LOGGER.info("Async task starting. This message is logged by the async task thread");
                    try {
                        Thread.sleep(1000);
                        LOGGER.info("Async task is ending. This message is logged by the async task thread");
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        LOGGER.log(Level.SEVERE, "The async task thread was interrupted.", e);
                    }
                }
                """;

        var classCode = """
                public class MyClass {
                %s
                }
                """;

        // Requires JDK 12
        String fullCode = classCode.formatted(methodCode.indent(4));

        System.out.println(fullCode);
    }
}