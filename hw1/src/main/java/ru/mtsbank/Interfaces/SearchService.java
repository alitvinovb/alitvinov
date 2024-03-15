package ru.mtsbank.Interfaces;

import ru.mtsbank.Exceptions.InvalidAnimalBirthDateException;
import ru.mtsbank.Exceptions.InvalidAnimalException;

public interface SearchService {
    public void checkLeapYearAnimal(Animal animal) throws InvalidAnimalException, InvalidAnimalBirthDateException;
}
