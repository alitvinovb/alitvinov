package ru.mtsbank.Services;

import ru.mtsbank.Animals.AnimalAbstract;
import ru.mtsbank.Interfaces.Animal;
import ru.mtsbank.Interfaces.AnimalRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AnimalRepositoryImpl implements AnimalRepository {
    public Map<String, LocalDate> findLeapYearNames(List<AnimalAbstract> animals)
    {
        if (animals == null)
            return null;

        Map<String, LocalDate> result = new HashMap<String, LocalDate>();
        for(var animal : animals)
        {
            result.put(animal.getClass().getName() + " " + animal.getName(), animal.getBirdthDate());
        }

        return result;
    }

    public Map<Animal, Integer> findOlderAnimal(List<AnimalAbstract> animals, int age)
    {
        if (animals == null)
            return null;

        Map<Animal, Integer> result = new HashMap<Animal, Integer>();
        AnimalAbstract olderAnimal = null;
        for(var animal : animals)
        {
            var bDay = animal.getBirdthDate();
            if (bDay != null) {
                if (bDay.plusYears(age).isBefore(LocalDate.now())) {
                    result.put(animal, Period.between(bDay, LocalDate.now()).getYears());
                }
                if (olderAnimal == null || olderAnimal.getBirdthDate().isBefore(bDay))
                {
                    olderAnimal = animal;
                }
            }
        }

        if (result.isEmpty() && olderAnimal != null) {
            // найти и добавить самого старого
            result.put(olderAnimal, Period.between(olderAnimal.getBirdthDate(), LocalDate.now()).getYears());
        }

        return result;
    }

    public Map<String, Long> findDuplicate(List<AnimalAbstract> animals)
    {
        if (animals == null)
            return null;

        Map<String, Long> result = animals.stream()
                .collect(Collectors.groupingBy(AnimalAbstract::getName, Collectors.counting()));

        return result;
    }
}
