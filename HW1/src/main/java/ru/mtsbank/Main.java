package ru.mtsbank;

import ru.mtsbank.Animals.Dog;
import ru.mtsbank.Exceptions.InvalidAnimalBirthDateException;
import ru.mtsbank.Exceptions.InvalidAnimalException;
import ru.mtsbank.Services.CreateAnimalServiceImpl;
import ru.mtsbank.Services.SearchServiceImpl;

import java.time.LocalDate;

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
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        try {
            searchService.checkLeapYearAnimal(new Dog(null));
        }
        catch (Exception ex)
        {
            System.out.println(ex.getMessage());
        }

        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2023,11,1)));
        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2020,12,4)));
    }
}
