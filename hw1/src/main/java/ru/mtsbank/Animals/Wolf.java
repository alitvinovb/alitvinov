package ru.mtsbank.Animals;

import java.time.LocalDate;

public class Wolf extends Predator {
    public Wolf(LocalDate birdthDate) {
        super(birdthDate);
        name ="Волк";
    }

    public Wolf(LocalDate birdthDate, Double cost) {
        super(birdthDate, cost);
        name ="Волк";
    }
    public Wolf(LocalDate birdthDate, Double cost, String breed, String name) {
        super(birdthDate, cost, breed, name);
    }

    public Wolf() {
        super();
    }
}
