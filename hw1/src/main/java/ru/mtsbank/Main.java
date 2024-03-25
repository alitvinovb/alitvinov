package ru.mtsbank;

import ru.mtsbank.Animals.*;
import ru.mtsbank.Exceptions.InvalidAnimalBirthDateException;
import ru.mtsbank.Exceptions.InvalidAnimalException;
import ru.mtsbank.Interfaces.AnimalRepository;
import ru.mtsbank.Services.AnimalRepositoryImpl;
import ru.mtsbank.Services.CreateAnimalServiceImpl;
import ru.mtsbank.Services.SearchServiceImpl;

import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) throws InvalidAnimalException, InvalidAnimalBirthDateException {

        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();

        System.out.println("CreateAnimals");
        animalService.createAnimals(10);

        System.out.println("CreateAnimalsSuper");
        animalService.createAnimalsSuper(10);

        System.out.println("CreateAnimalsDoWhile");
        animalService.createAnimalsDoWhile(10);

        SearchServiceImpl searchService = new SearchServiceImpl();
        try {
            searchService.checkLeapYearAnimal(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            searchService.checkLeapYearAnimal(new Dog(null));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2023, 11, 1)));
        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2020, 12, 4)));

        var hashMap = animalService.createAnimalsRandom(20);
        hashMap.forEach((key, value) ->
        {
            System.out.println(key);
            for (var animal : value) {
                System.out.println(animal.getName() + " " + animal.getBirdthDate());
            }
        });

        List<AnimalAbstract> dogs = new ArrayList<AnimalAbstract>();
        dogs.add(new Dog(LocalDate.of(2023, 1, 1)));
        dogs.add(new Dog(LocalDate.of(2020, 1, 1)));
        dogs.add(new Dog(LocalDate.of(2020, 1, 1)));
        var repo = new AnimalRepositoryImpl();
        var result = repo.findAverageAge(dogs);
        System.out.println("Avg Age: " + result);

        List<AnimalAbstract> animals = new ArrayList<AnimalAbstract>();
        animals.add(new Dog(LocalDate.of(2023, 1, 1), 20.0));
        animals.add(new Cat(LocalDate.of(2012, 1, 1), 50.0));
        animals.add(new Cat(LocalDate.of(2015, 1, 1), 60.0));
        animals.add(new Cat(LocalDate.of(2022, 1, 1), 60.0));
        animals.add(new Wolf(LocalDate.of(2020, 1, 1), 30.0));
        animals.add(new Cat(LocalDate.of(2020, 1, 1), 40.0));
        animals.add(new Shark(LocalDate.of(2020, 1, 1), 10.0));

        var minCostResult = repo.findMinCost(animals);
        for (var animal : minCostResult) {
            System.out.println(animal);
        }

        var animalResult = repo.findOldAndExpensive(animals);
        for (var animal : animalResult) {
            System.out.println(animal.getName() + animal.getBirdthDate());
        }
    }
}
