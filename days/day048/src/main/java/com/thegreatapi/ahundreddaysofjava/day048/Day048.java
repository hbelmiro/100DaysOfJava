package com.thegreatapi.ahundreddaysofjava.day048;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class Day048 {

    public static void main(String[] args) {
        System.out.println(lastAlbumWith("Slash").apply(getGunsNRosesAlbums()).title());

        System.out.println(lastAlbumWith("Slash", "Izzy Stradlin").apply(getGunsNRosesAlbums()).title());

        System.out.println(firstAlbumWith("Matt Sorum").apply(getGunsNRosesAlbums()).title());

        /*
        Output:
        The Spaghetti Incident
        Use Your Illusion II
        Use Your Illusion I
         */
    }

    private static Function<List<Album>, Album> firstAlbumWith(String... bandMembers) {
        return albumsWith(bandMembers).andThen(sortByYear())
                                      .andThen(firstAlbum());
    }

    private static Function<List<Album>, Album> lastAlbumWith(String... bandMembers) {
        return albumsWith(bandMembers).andThen(sortByYear())
                                      .andThen(lastAlbum());
    }

    private static Function<List<Album>, Album> lastAlbum() {
        return albums -> albums.get(albums.size() - 1);
    }

    private static Function<List<Album>, Album> firstAlbum() {
        return albums -> albums.get(0);
    }

    private static UnaryOperator<List<Album>> sortByYear() {
        return albums -> albums.stream()
                               .sorted(Comparator.comparing(Album::year))
                               .toList();
    }

    private static Function<List<Album>, List<Album>> albumsWith(String... bandMembers) {
        if (bandMembers.length < 1) {
            throw new IllegalArgumentException("");
        } else {
            Function<List<Album>, List<Album>> resultFunction = albums -> albums;
            for (String bandMember : bandMembers) {
                resultFunction = resultFunction.andThen(albumsWith(bandMember));
            }
            return resultFunction;
        }
    }

    private static UnaryOperator<List<Album>> albumsWith(String bandMember) {
        return albums -> albums.stream()
                               .filter(album -> album.lineup().contains(bandMember))
                               .toList();
    }

    private static List<Album> getGunsNRosesAlbums() {
        List<String> lineup87to90 = List.of("Axl Rose", "Slash", "Izzy Stradlin", "Duff McKagan", "Steven Adler");
        List<String> lineup91 = List.of("Axl Rose", "Slash", "Izzy Stradlin", "Duff McKagan", "Matt Sorum", "Dizzy Reed");
        List<String> lineup91to93 = List.of("Axl Rose", "Slash", "Gilby Clarke", "Duff McKagan", "Matt Sorum", "Dizzy Reed");
        List<String> lineup2008 = List.of("Axl Rose", "Bumblefoot", "Richard Fortus", "Tommy Stinson", "Frank Ferrer", "Chris Pitman", "Dizzy Reed");

        return List.of(
                new Album("Appetite for Destruction", lineup87to90, 1987),
                new Album("G N' R Lies", lineup87to90, 1988),
                new Album("Use Your Illusion I", lineup91, 1991),
                new Album("Use Your Illusion II", lineup91, 1991),
                new Album("The Spaghetti Incident", lineup91to93, 1993),
                new Album("Chinese Democracy", lineup2008, 2008)
        );
    }

    private record Album(String title, List<String> lineup, int year) {
    }
}
