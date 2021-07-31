package com.thegreatapi.ahundreddaysofjava.day072;

import com.thegreatapi.ahundreddaysofjava.day072.animal.Animal;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@ApplicationScoped
class Application {

    private final Animal dog;
    private final Animal cat;

    @Inject
    private Application(@Named("Dog") Animal dog, @Named("Cat") Animal cat) {
        this.dog = dog;
        this.cat = cat;
    }

    public void run() {
        System.out.println("The dog says: " + dog.speak());
        System.out.println("The cat says: " + cat.speak());
    }
}