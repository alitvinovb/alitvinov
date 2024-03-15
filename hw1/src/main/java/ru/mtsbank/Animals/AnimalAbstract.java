package ru.mtsbank.Animals;

import ru.mtsbank.Interfaces.Animal;

import java.time.LocalDate;

public abstract class AnimalAbstract implements Animal {
    public AnimalAbstract(LocalDate birdthDate)
    {
     this.birdthDate = birdthDate;
    }
    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;

    public LocalDate getBirdthDate() {
        return birdthDate;
    }

    protected LocalDate birdthDate;

    public abstract String getBreed();

    public abstract String getName();

    public abstract Double getCost();

    public abstract String getCharacter();

}
