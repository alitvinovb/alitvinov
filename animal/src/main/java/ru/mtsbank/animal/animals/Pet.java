package ru.mtsbank.animal.animals;


import java.time.LocalDate;

public class Pet extends AnimalAbstract {

    public Pet(LocalDate birdthDate) {
        super(birdthDate);
        name = "Домашние";
    }

    public Pet(LocalDate birdthDate, Double cost) {
        super(birdthDate, cost);
        name = "Домашние";
    }
    public Pet(LocalDate birdthDate, Double cost, String breed, String name) {
        super(birdthDate, cost, breed, name);
    }
    public String getBreed() {
        return breed;
    }

    public String getName() {
        return name;
    }

    public String getSecretInformation(){ return secretInformation;}

    public Double getCost() {
        return cost;
    }

    public String getCharacter() {
        return character;
    }
}
