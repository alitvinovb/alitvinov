package ru.mtsbank.Services;

import ru.mtsbank.Animals.*;
import ru.mtsbank.Interfaces.Animal;
import ru.mtsbank.Interfaces.CreateAnimalService;

import java.time.LocalDate;
import java.util.*;

public class CreateAnimalServiceImpl implements CreateAnimalService {

    @Override
    public void createAnimals(int number) {
        Animal[] animals = new Animal[number];

        int i = 0;
        while (i < number) {
            if (i == 0) {
                animals[i] = new Dog(LocalDate.of(1990 + i, i + 1, i + 1));
            } else if (i > 3) {
                animals[i] = new Cat(LocalDate.of(1990 + i, i + 1, i + 1));
            } else {
                animals[i] = new Wolf(LocalDate.of(1990 + i, i + 1, i + 1));
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
                animals[i] = new Dog(LocalDate.of(1990 + i, i + 1, i + 1));
            } else if (i > 3) {
                animals[i] = new Cat(LocalDate.of(1990 + i, i + 1, i + 1));
            } else {
                animals[i] = new Wolf(LocalDate.of(1990 + i, i + 1, i + 1));
            }
            i++;
        } while (i < number);

        for (var animal : animals) {
            System.out.println(animal.getName() + " " + animal.getBirdthDate());
        }
    }

    public Map<String, List<Animal>> createAnimalsRandom(int number) {
        var animalMap = new HashMap<String, List<Animal>>();
        var random = new Random();
        var animals = new ArrayList<Animal>();

        for (int i = 0; i < number; i++) {
            var rnd = random.nextInt(4);
            var year = random.nextInt(24);
            var month = random.nextInt(12);
            var day = random.nextInt(25);
            var bDay = LocalDate.of(2000 + year, 1 + month, 1 + day);

            AnimalAbstract animal;
            // по хорошему это должен быть метод getRadnomAnimal
            if (rnd == 0) {
                animal = new Cat(bDay);
            } else if (rnd == 1) {
                animal = new Dog(bDay);
            } else if (rnd == 2) {
                animal = new Wolf(bDay);
            } else {
                animal = new Shark(bDay);
            }

            // и это метод addAnimal
            if (animalMap.containsKey(animal.getClass().getName())) {
                var lst = animalMap.get(animal.getClass().getName());
                lst.add(animal);
            } else {
                var lst = new ArrayList<Animal>();
                lst.add(animal);
                animalMap.put(animal.getClass().getName(), lst);
            }

        }

        return animalMap;
    }
}
