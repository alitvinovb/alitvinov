package Services;

import Animals.Cat;
import Animals.Dog;
import Animals.Wolf;
import Interfaces.IAnimal;
import Interfaces.ICreateAnimalService;

import static java.lang.System.in;

public class CreateAnimalService implements ICreateAnimalService {
    @Override
    public void CreateAnimals(int number) {
        IAnimal[] animals = new IAnimal[number];

        for(int i=0; i<number;i++)
        {
            if (i == 0)
            {
                animals[i] = new Dog();
            }
            else if (i>3)
            {
                animals[i] = new Cat();
            }
            else
            {
                animals[i] = new Wolf();
            }
        }
        for(var animal : animals)
        {
            System.out.println(animal.getName());
        }
    }

    public void CreateAnimalsSuper(int number)
    {
        ICreateAnimalService.super.CreateAnimals(number);
    }

    public void CreateAnimalsDoWhile(int number) {
        IAnimal[] animals = new IAnimal[number];
        int i =0;
        do
        {
            if (i == 0)
            {
                animals[i] = new Dog();
            }
            else if (i>3)
            {
                animals[i] = new Cat();
            }
            else
            {
                animals[i] = new Wolf();
            }
            i++;
        } while (i<number);

        for(var animal : animals)
        {
            System.out.println(animal.getName());
        }
    }
}
