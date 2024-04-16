package ru.mtsbank.animal.interfaces;


import ru.mtsbank.animal.animals.*;

import java.time.LocalDate;
import java.util.*;

public interface CreateAnimalService {
    default void createAnimals(int number) {
        Animal[] animals = new Animal[number];

        for (int i = 0; i < number; i++) {
            if (i == 0) {
                animals[i] = new Wolf(LocalDate.of(1990 + i, i + 1, i + 1));
            } else if (i > 3) {
                animals[i] = new Dog(LocalDate.of(1990 + i, i + 1, i + 1));
            } else {
                animals[i] = new Wolf(LocalDate.of(1990 + i, i + 1, i + 1));
            }
        }
        for (var animal : animals) {
            System.out.println(animal.getName() + " " + animal.getBirdthDate());
        }
    }

    public Map<String, List<Animal>> createAnimalsRandom(int number);

    public void createAnimalsDoWhile(int number);
}
