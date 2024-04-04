package ru.mtsbank.Animals;

import java.time.LocalDate;

public class AnimalNonAbstract extends AnimalAbstract {
    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getSecretInformation() {
        return secretInformation;
    }

    public Double getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }

    public AnimalNonAbstract(LocalDate birdthDate, Double cost, String breed, String name, String secretInformation) {
        super(birdthDate, cost, breed, name, secretInformation);
    }
}
