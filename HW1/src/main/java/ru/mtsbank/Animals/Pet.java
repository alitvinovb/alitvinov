package ru.mtsbank.Animals;

import java.time.LocalDate;

public class Pet extends AnimalAbstract {

    public Pet(LocalDate birdthDate) {
        super(birdthDate);
        name = "Домашние";
    }

    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public Double getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }
}
