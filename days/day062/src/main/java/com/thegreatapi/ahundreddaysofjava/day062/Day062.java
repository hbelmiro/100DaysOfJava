package com.thegreatapi.ahundreddaysofjava.day062;

import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;

import java.util.List;

public class Day062 {

    public static void main(String[] args) throws Exception {
        Musician steveHarris = new Musician("Steve Harris", "Bass", "England", "Iron Maiden");
        Musician michaelSchenker = new Musician("Michael Schenker", "Guitar", "Germany", "UFO");
        Musician daveLombardo = new Musician("Dave Lombardo", "Drums", "Cuba", "Slayer");

        List<Musician> musicians = List.of(steveHarris, michaelSchenker, daveLombardo);

        try (Jsonb jsonb = JsonbBuilder.create()) {
            String json = jsonb.toJson(musicians);
            System.out.println(json);

            String jsonJohnLord = "{\"bandName\":\"Deep Purple\",\"country\":\"England\",\"instrument\":\"Keyboards\",\"name\":\"John Lord\"}";

            Musician johnLord = jsonb.fromJson(jsonJohnLord, Musician.class);

            System.out.println(johnLord);
        }
    }

    public static class Musician {
        private String name;
        private String instrument;
        private String country;
        private String bandName;

        public Musician() {
        }

        public Musician(String name, String instrument, String country, String bandName) {
            this.name = name;
            this.instrument = instrument;
            this.country = country;
            this.bandName = bandName;
        }

        @SuppressWarnings("unused")
        public String getName() {
            return name;
        }

        @SuppressWarnings("unused")
        public String getInstrument() {
            return instrument;
        }

        @SuppressWarnings("unused")
        public String getCountry() {
            return country;
        }

        @SuppressWarnings("unused")
        public String getBandName() {
            return bandName;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setInstrument(String instrument) {
            this.instrument = instrument;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setBandName(String bandName) {
            this.bandName = bandName;
        }

        @Override
        public String toString() {
            return "Musician{" +
                    "name='" + name + '\'' +
                    ", instrument='" + instrument + '\'' +
                    ", country='" + country + '\'' +
                    ", bandName='" + bandName + '\'' +
                    '}';
        }
    }
}