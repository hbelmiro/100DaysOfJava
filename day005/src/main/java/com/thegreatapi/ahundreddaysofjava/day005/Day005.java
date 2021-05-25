package com.thegreatapi.ahundreddaysofjava.day005;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Day005 {

    private static final String GUITAR = "Guitar";
    private static final String DRUMS = "Drums";
    private static final String BASS = "Bass";
    private static final String VOCALS = "Vocals";
    private static final String KEYBOARDS = "Keyboards";

    public static void main(String[] args) {
        List<BandMember> pinkFloyd = List.of(
                new BandMember("David Gilmour", GUITAR),
                new BandMember("Roger Waters", BASS),
                new BandMember("Richard Wright", KEYBOARDS),
                new BandMember("Nick Mason", DRUMS)
        );

        List<BandMember> ironMaiden = List.of(
                new BandMember("Bruce Dickinson", VOCALS),
                new BandMember("Steve Harris", BASS),
                new BandMember("Adrian Smith", GUITAR),
                new BandMember("Dave Murray", GUITAR),
                new BandMember("Nicko McBrain", DRUMS)
        );

        List<BandMember> blackSabbath = List.of(
                new BandMember("Ozzy Osbourne", VOCALS),
                new BandMember("Geezer Butler", BASS),
                new BandMember("Toni Iommi", GUITAR),
                new BandMember("Bill Ward", DRUMS)
        );

        Stream<BandMember> musicians = Stream.concat(Stream.concat(pinkFloyd.stream(), ironMaiden.stream()), blackSabbath.stream());

        List<String> guitarPlayers = musicians.filter(bandMember -> GUITAR.equals(bandMember.instrument))
                                              .map(BandMember::name)
                                              .collect(Collectors.toList());

        System.out.println(guitarPlayers);
    }

    static record BandMember(String name, String instrument) {
    }
}
