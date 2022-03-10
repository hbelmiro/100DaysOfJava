package com.thegreatapi.ahundreddaysofjava.day027;

import java.util.List;

import static java.util.stream.Collectors.joining;

public final class Day027 {

    public static void main(String[] args) {
        List<Player> players = createList();

        String message = players.stream()
                                .map(Player::toString)
                                .collect(joining(System.lineSeparator()));

        System.out.println(message);
    }

    private static List<Player> createList() {
        var messi = new Player("Lionel Messi", "PSG", "Argentina", 42);
        var cr7 = new Player("Cristiano Ronaldo", "Manchester United", "Portugal", 50);
        var lukaku = new Player("Romelu Lukaku", "Chelsea", "Belgium", 41);

        return List.of(messi, cr7, lukaku);
    }

    private record Player(String name, String club, String coutry, int numberOfGoals) {
    }
}
