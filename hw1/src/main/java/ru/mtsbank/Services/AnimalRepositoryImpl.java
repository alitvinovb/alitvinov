package ru.mtsbank.Services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import ru.mtsbank.Animals.AnimalAbstract;
import ru.mtsbank.Interfaces.Animal;
import ru.mtsbank.Interfaces.AnimalRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

public class AnimalRepositoryImpl implements AnimalRepository {
    public Map<String, LocalDate> findLeapYearNames(List<AnimalAbstract> animals) {
        if (animals == null)
            return null;

        Map<String, LocalDate> result = new HashMap<String, LocalDate>();
        for (var animal : animals) {
            result.put(animal.getClass().getName() + " " + animal.getName(), animal.getBirdthDate());
        }

        return result;
    }

    public Map<Animal, Integer> findOlderAnimal(List<AnimalAbstract> animals, int age) {
        if (animals == null)
            return null;

        Map<Animal, Integer> result = new HashMap<Animal, Integer>();
        AnimalAbstract olderAnimal = null;
        for (var animal : animals) {
            var bDay = animal.getBirdthDate();
            if (bDay != null) {
                if (bDay.plusYears(age).isBefore(LocalDate.now())) {
                    result.put(animal, Period.between(bDay, LocalDate.now()).getYears());
                }
                if (olderAnimal == null || olderAnimal.getBirdthDate().isBefore(bDay)) {
                    olderAnimal = animal;
                }
            }
        }

        if (result.isEmpty() && olderAnimal != null) {
            // найти и добавить самого старого
            result.put(olderAnimal, Period.between(olderAnimal.getBirdthDate(), LocalDate.now()).getYears());
        }

        var mapper = new ObjectMapper();

        mapper.registerModule(new JavaTimeModule());
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        for (var res : result.entrySet()) {
            try {
                String json = mapper.writeValueAsString(res.getKey());
                String fileUrl = Paths.get("").toAbsolutePath().toString() + "\\resources\\results\\findOlderAnimal.json";
                var filePath = Path.of(fileUrl);

                Files.createDirectories(filePath.getParent());
                if (!Files.exists(filePath)) {
                    Files.createFile(filePath);
                }

                Files.writeString(filePath, json);


            } catch (Exception ex) {
            }
        }

        return result;
    }

    public Map<String, Long> findDuplicate(List<AnimalAbstract> animals) {
        if (animals == null)
            return null;

        Map<String, Long> result = animals.stream()
                .collect(Collectors.groupingBy(AnimalAbstract::getName, Collectors.counting()));

        return result;
    }

    public int findAverageAge(List<AnimalAbstract> animals) {
        if (animals == null || animals.isEmpty())
            return 0;

        return (int) animals.stream().mapToInt(x -> Period.between(x.getBirdthDate(), LocalDate.now()).getYears())
                .average().orElse(0);
    }

    public List<String> findMinCost(List<AnimalAbstract> animals) {
        List<String> result = animals.stream().sorted((o1, o2) -> o1.getCost().
                        compareTo(o2.getCost())).limit(3).sorted(comparing(Animal::getName).reversed()).
                map(x -> x.getName()).
                collect(Collectors.toList());

        return result;
    }

    public List<AnimalAbstract> findOldAndExpensive(List<AnimalAbstract> animals) {
        if (animals == null || animals.isEmpty())
            return null;

        var avgCost = animals.stream().mapToDouble(x -> x.getCost()).average().orElse(0);
        var result = animals.stream()
                .filter(item -> item.getCost() > avgCost && Period.between(item.getBirdthDate(), LocalDate.now()).getYears() > 5)
                .sorted((o1, o2) -> o1.getBirdthDate().
                        compareTo(o2.getBirdthDate()))
                .collect(Collectors.toList());

        return result;
    }
}
