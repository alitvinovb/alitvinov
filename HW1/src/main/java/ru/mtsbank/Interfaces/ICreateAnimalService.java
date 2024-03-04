package Interfaces;

import Animals.Cat;
import Animals.Dog;
import Animals.Wolf;

public interface ICreateAnimalService {
    default void createAnimals(int number) {
        IAnimal[] animals = new IAnimal[number];

        for (int i = 0; i < number; i++) {
            if (i == 0) {
                animals[i] = new Wolf();
            } else if (i > 3) {
                animals[i] = new Dog();
            } else {
                animals[i] = new Wolf();
            }
        }
        for (var animal : animals) {
            System.out.println(animal.getName());
        }
    }

    public void createAnimalsDoWhile(int number);
}
