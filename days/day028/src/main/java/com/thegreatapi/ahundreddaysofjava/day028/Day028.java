package com.thegreatapi.ahundreddaysofjava.day028;

import java.util.Arrays;
import java.util.List;

import static java.util.Comparator.comparing;

public final class Day028 {

    public static void main(String[] args) {
        var messi = new Player("Lionel Messi", "PSG", "Argentina", 42);
        var cr7 = new Player("Cristiano Ronaldo", "Manchester United", "Portugal", 50);
        var lukaku = new Player("Romelu Lukaku", "Chelsea", "Belgium", 41);

        List<Player> players = Arrays.asList(messi, cr7, lukaku);

        players.sort(comparing(Player::numberOfGoals).reversed());

        System.out.println("Top Scorers:");
        players.forEach(System.out::println);
    }

    private record Player(String name, String club, String country, int numberOfGoals) {
    }
}