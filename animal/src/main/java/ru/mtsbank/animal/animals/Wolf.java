package ru.mtsbank.animal.animals;
import java.time.LocalDate;


public class Wolf extends Predator {
    public Wolf(LocalDate birdthDate) {
        super(birdthDate);
        name ="Волк";
    }

    public Wolf(LocalDate birdthDate, String name) {
        super(birdthDate);
        this.name = name;
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
