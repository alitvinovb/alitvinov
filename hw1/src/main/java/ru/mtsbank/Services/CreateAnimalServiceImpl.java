package ru.mtsbank.Services;

import ru.mtsbank.Animals.Cat;
import ru.mtsbank.Animals.Dog;
import ru.mtsbank.Animals.Wolf;
import ru.mtsbank.Interfaces.Animal;
import ru.mtsbank.Interfaces.CreateAnimalService;

import java.time.LocalDate;

public class CreateAnimalServiceImpl implements CreateAnimalService {
    @Override
    public void createAnimals(int number) {
        Animal[] animals = new Animal[number];

        int i = 0;
        while (i < number) {
            if (i == 0) {
                animals[i] = new Dog(LocalDate.of(1990+i,i+1,i+1));
            } else if (i > 3) {
                animals[i] = new Cat(LocalDate.of(1990+i,i+1,i+1));
            } else {
                animals[i] = new Wolf(LocalDate.of(1990+i,i+1,i+1));
            }
            i++;
        }
        for (var animal : animals) {
            System.out.println(animal.getName() + " " + animal.getBirdthDate());
        }
    }

    public void createAnimalsSuper(int number) {
        CreateAnimalService.super.createAnimals(number);
    }

    public void createAnimalsDoWhile(int number) {
        Animal[] animals = new Animal[number];
        int i = 0;
        do {
            if (i == 0) {
                animals[i] = new Dog(LocalDate.of(1990+i,i+1,i+1));
            } else if (i > 3) {
                animals[i] = new Cat(LocalDate.of(1990+i,i+1,i+1));
            } else {
                animals[i] = new Wolf(LocalDate.of(1990+i,i+1,i+1));
            }
            i++;
        } while (i < number);

        for (var animal : animals) {
            System.out.println(animal.getName() + " " + animal.getBirdthDate());
        }
    }
}
