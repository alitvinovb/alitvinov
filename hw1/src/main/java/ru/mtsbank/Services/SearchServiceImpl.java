package ru.mtsbank.Services;

import ru.mtsbank.Exceptions.InvalidAnimalBirthDateException;
import ru.mtsbank.Exceptions.InvalidAnimalException;
import ru.mtsbank.Interfaces.Animal;
import ru.mtsbank.Interfaces.SearchService;

import java.time.LocalDate;

public class SearchServiceImpl implements SearchService {
    public void checkLeapYearAnimal(Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException {
        if (animal == null) {
            throw new InvalidAnimalException("На вход пришёл некорректный объект " + LocalDate.now());
        }

        var birdthDate = animal.getBirdthDate();
        if (birdthDate == null) {
            throw new InvalidAnimalBirthDateException("У животного " + animal.getName() + " не указана его дата рождения");
        }

        int remainder = birdthDate.getYear() % 4;
        if (remainder == 0) {
            System.out.println(animal.getName() + " родился в високсный год " + animal.getBirdthDate());
        } else {
            System.out.println(animal.getName() + " родился в не високсный год " + animal.getBirdthDate());
        }

    }
}
