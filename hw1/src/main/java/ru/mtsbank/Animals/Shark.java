package ru.mtsbank.Animals;

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
}
