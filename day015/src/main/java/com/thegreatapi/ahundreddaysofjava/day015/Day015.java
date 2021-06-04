package com.thegreatapi.ahundreddaysofjava.day015;

import javax.annotation.Nullable;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Day015 {

    public static void main(String[] args) {
        Person john = Person.builder()
                            .name("John")
                            .children(List.of(
                                    Person.builder()
                                          .name("Amanda")
                                          .petName("Toto")
                                          .build()
                            ))
                            .build();

        System.out.println(john);
    }

    public static class Person {

        private final String name;

        private final List<Person> children;

        @Nullable
        private final String petName;

        private Person(Builder builder) {
            name = Objects.requireNonNull(builder.name);
            children = builder.children != null ? builder.children : List.of();
            petName = builder.petName;
        }

        public String getName() {
            return name;
        }

        public List<Person> getChildren() {
            return children;
        }

        @Nullable
        public String getPetName() {
            return petName;
        }

        public static Builder builder() {
            return new Builder();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", children=" + children +
                    ", petName='" + petName + '\'' +
                    '}';
        }
    }

    public static final class Builder {

        private String name;

        private List<Person> children;

        @Nullable
        private String petName;

        private Builder() {
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder children(List<Person> children) {
            this.children = Collections.unmodifiableList(children);
            return this;
        }

        public Builder petName(String petName) {
            this.petName = petName;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }
}