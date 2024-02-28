package ru.mtsbank;
import Services.CreateAnimalService;

public class Main {
    public static void main(String[] args) {

        CreateAnimalService animalService = new CreateAnimalService();

        System.out.println("CreateAnimals");
        animalService.CreateAnimals(10);

        System.out.println("CreateAnimalsSuper");
        animalService.CreateAnimalsSuper(10);

        System.out.println("CreateAnimalsDoWhile");
        animalService.CreateAnimalsDoWhile(10);
        }
    }
