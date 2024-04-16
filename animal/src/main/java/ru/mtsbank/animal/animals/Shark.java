package ru.mtsbank.animal.animals;


import java.time.LocalDate;

public class Shark extends Predator {
    public Shark(LocalDate birdthDate) {
        super(birdthDate);
        name = "Акула";
    }

    public Shark(LocalDate birdthDate, Double cost) {
        super(birdthDate ,cost);
        name = "Акула";
    }
    public Shark(LocalDate birdthDate, Double cost, String breed, String name) {
        super(birdthDate, cost, breed, name);
    }
}
