package com.thegreatapi.ahundreddaysofjava.day056;

public final class Day056 {

    private static final String RESET_COLOR = "\u001B[0m";

    public static void main(String[] args) {
        var color = Color.valueOf(args[0]);
        System.out.println(color.getAnsiColor() + "thegreatapi.com" + RESET_COLOR);
    }

    @SuppressWarnings("unused")
    public enum Color {
        BLACK("\u001B[30m"),
        BLUE("\u001B[34m"),
        RED("\u001B[31m"),
        YELLOW("\u001B[33m"),
        WHITE("\u001B[37m");

        private final String ansiColor;

        Color(String ansiColor) {
            this.ansiColor = ansiColor;
        }

        public final String getAnsiColor() {
            return ansiColor;
        }
    }
}