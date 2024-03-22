package ru.mtsbank.Animals;

import java.time.LocalDate;

public class Predator extends AnimalAbstract {
    public Predator(LocalDate birdthDate) {
        super(birdthDate);
        name = "Хищник";
        this.birdthDate = birdthDate;
    }

    public Predator(LocalDate birdthDate, Double cost) {
        super(birdthDate, cost);
        name = "Хищник";
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
