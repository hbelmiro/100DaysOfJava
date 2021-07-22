package com.thegreatapi.ahundreddaysofjava.day064;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static java.util.stream.Collectors.partitioningBy;

public class Day064 {

    public static void main(String[] args) {
        Predicate<Band> isEuropeanBand = band -> List.of(Europe.values()).contains(band.country);

        Map<Boolean, List<Band>> europeanBandsAndOthers = getBands().stream()
                                                                    .collect(partitioningBy(isEuropeanBand));

        List<Band> europeanBands = europeanBandsAndOthers.get(true);
        List<Band> otherBands = europeanBandsAndOthers.get(false);

        System.out.println("Bands from Europe: " + europeanBands);
        System.out.println("Other bands: " + otherBands);
    }

    private static List<Band> getBands() {
        return List.of(
                new Band("Sepultura", America.BRAZIL),
                new Band("Gojira", Europe.FRANCE),
                new Band("Rush", America.CANADA),
                new Band("AC/DC", Oceania.NEW_ZEALAND),
                new Band("Iron Maiden", Europe.ENGLAND),
                new Band("Scorpions", Europe.GERMANY),
                new Band("Kiss", America.USA),
                new Band("Mastodon", America.USA)
        );
    }

    static record Band(String name, Country country) {
    }

    interface Country {
    }

    enum Europe implements Country {
        ENGLAND,
        GERMANY,
        FRANCE
    }

    enum America implements Country {
        BRAZIL,
        ARGENTINA,
        USA,
        CANADA
    }

    enum Oceania implements Country {
        AUSTRALIA,
        NEW_ZEALAND
    }
}