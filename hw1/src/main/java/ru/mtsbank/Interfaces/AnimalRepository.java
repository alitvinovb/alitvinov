package ru.mtsbank.Interfaces;

import ru.mtsbank.Animals.AnimalAbstract;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface AnimalRepository {
    public Map<String, LocalDate> findLeapYearNames(List<AnimalAbstract> animals);
    public Map<Animal, Integer> findOlderAnimal(List<AnimalAbstract> animals, int age);
    public Map<String, Long> findDuplicate(List<AnimalAbstract> animals);
    public int findAverageAge(List<AnimalAbstract> animals);

    public void findMinCost(List<AnimalAbstract> animals);
}
