package ru.mtsbank.Services;

import org.junit.Assert;
import org.junit.Test;
import ru.mtsbank.Animals.AnimalAbstract;
import ru.mtsbank.Animals.Cat;
import ru.mtsbank.Animals.Dog;
import ru.mtsbank.Animals.Wolf;
import ru.mtsbank.Interfaces.Animal;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class AnimalRepositoryImplTest {

    @Test
    public void findLeapYearNames() {
        var animalRepository = new AnimalRepositoryImpl();
        var animals = new ArrayList<AnimalAbstract>();
        animals.add(new Dog(LocalDate.of(2024, 1, 1)));

        var result = animalRepository.findLeapYearNames(animals);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(animals.get(0).getBirdthDate(), result.values().iterator().next());
    }

    @Test
    public void findOlderAnimal() {
        var animalRepository = new AnimalRepositoryImpl();
        var animals = new ArrayList<AnimalAbstract>();
        var oldWolf = new Wolf(LocalDate.of(200, 11, 1),50.0,"Волк","Полярник");
        animals.add(new Dog(LocalDate.of(2024, 1, 1)));
        animals.add(new Dog(LocalDate.of(2023, 1, 1)));
        animals.add(oldWolf);
        animals.add(new Cat(LocalDate.of(2023, 1, 1)));

        var result = animalRepository.findOlderAnimal(animals, 500);
        Assert.assertEquals(1, result.size());
        Assert.assertEquals(oldWolf.getBirdthDate(), result.keySet().iterator().next().getBirdthDate());
    }

    @Test
    public void findDuplicate() {
        var animalRepository = new AnimalRepositoryImpl();
        var animals = new ArrayList<AnimalAbstract>();
        var oldWolf = new Wolf(LocalDate.of(200, 11, 1));
        animals.add(new Dog(LocalDate.of(2024, 1, 1)));
        animals.add(new Dog(LocalDate.of(2024, 1, 1)));
        animals.add(oldWolf);
        animals.add(new Cat(LocalDate.of(2023, 1, 1)));

        var result = animalRepository.findDuplicate(animals);
        Long count = result.get("Собака");
        Assert.assertEquals(Long.valueOf(2), count);
    }
}