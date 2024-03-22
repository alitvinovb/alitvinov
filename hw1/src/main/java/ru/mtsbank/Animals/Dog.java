package ru.mtsbank.Animals;

import java.time.LocalDate;

public class Dog extends Pet {
    public Dog(LocalDate birdthDate) {
        super(birdthDate);
        name = "Собака";
    }

    public Dog(LocalDate birdthDate, Double cost) {
        super(birdthDate, cost);
        name = "Собака";
    }
}
