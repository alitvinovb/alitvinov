package ru.mtsbank.Animals;

import java.time.LocalDate;

public class Cat extends Pet {
    public Cat(LocalDate birdthDate) {
        super(birdthDate);
        name = "Мурзик";
    }

    public Cat(LocalDate birdthDate, Double cost) {
        super(birdthDate, cost);
        name = "Мурзик";
    }
}
