package ru.mtsbank.Animals;

import ru.mtsbank.Interfaces.Animal;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Random;

public abstract class AnimalAbstract implements Animal {
    public AnimalAbstract(LocalDate birdthDate) {
        this.birdthDate = birdthDate;
    }

    public AnimalAbstract(LocalDate birdthDate, Double cost) {
        this.birdthDate = birdthDate;
        this.cost = cost;
    }

    public AnimalAbstract(LocalDate birdthDate, Double cost, String breed, String name) {
        this.birdthDate = birdthDate;
        this.cost = cost;
        this.breed = breed;
        this.name = name;

        String fileUrl = Paths.get("").toAbsolutePath().toString() + "\\resources\\secretStore\\secretInformation.txt";
        var filePath = Path.of(fileUrl);
        try {

            var secretLines = Files.readAllLines(filePath);
            var random = new Random();
            int index = random.nextInt(secretLines.size());
            this.secretInformation = secretLines.get(index);

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public AnimalAbstract(LocalDate birdthDate, Double cost, String breed, String name, String secretInformation) {
        this.birdthDate = birdthDate;
        this.cost = cost;
        this.breed = breed;
        this.name = name;
        this.secretInformation = secretInformation;
    }


    public AnimalAbstract() {

    }

    protected String breed;
    protected String name;
    protected Double cost;
    protected String character;
    protected String secretInformation;

    public LocalDate getBirdthDate() {
        return birdthDate;
    }

    protected LocalDate birdthDate;

    public abstract String getBreed();

    public abstract String getName();

    public abstract Double getCost();

    public abstract String getCharacter();

    public abstract String getSecretInformation();
}
