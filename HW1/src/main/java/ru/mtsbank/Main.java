package ru.mtsbank;

import Services.CreateAnimalService;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService animalService = new CreateAnimalService();

        System.out.println("CreateAnimals");
        animalService.createAnimals(10);

        System.out.println("CreateAnimalsSuper");
        animalService.createAnimalsSuper(10);

        System.out.println("CreateAnimalsDoWhile");
        animalService.createAnimalsDoWhile(10);
    }
}
