package ru.mtsbank;

import ru.mtsbank.Animals.*;
import ru.mtsbank.Exceptions.InvalidAnimalBirthDateException;
import ru.mtsbank.Exceptions.InvalidAnimalException;
import ru.mtsbank.Interfaces.AnimalRepository;
import ru.mtsbank.Services.AnimalRepositoryImpl;
import ru.mtsbank.Services.CounterImpl;
import ru.mtsbank.Services.CreateAnimalServiceImpl;
import ru.mtsbank.Services.SearchServiceImpl;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) throws InvalidAnimalException, InvalidAnimalBirthDateException, InterruptedException, ExecutionException {

        CreateAnimalServiceImpl animalService = new CreateAnimalServiceImpl();

        System.out.println("CreateAnimals");
        animalService.createAnimals(10);

        System.out.println("CreateAnimalsSuper");
        animalService.createAnimalsSuper(10);

        System.out.println("CreateAnimalsDoWhile");
        animalService.createAnimalsDoWhile(10);

        SearchServiceImpl searchService = new SearchServiceImpl();
        try {
            searchService.checkLeapYearAnimal(null);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        try {
            searchService.checkLeapYearAnimal(new Dog(null));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2023, 11, 1)));
        searchService.checkLeapYearAnimal(new Dog(LocalDate.of(2020, 12, 4)));

        var hashMap = animalService.createAnimalsRandom(20);
        hashMap.forEach((key, value) ->
        {
            System.out.println(key);
            for (var animal : value) {
                System.out.println(animal.getName() + " " + animal.getBirdthDate());
            }
        });

        List<AnimalAbstract> dogs = new ArrayList<AnimalAbstract>();
        dogs.add(new Dog(LocalDate.of(2023, 1, 1)));
        dogs.add(new Dog(LocalDate.of(2020, 1, 1)));
        dogs.add(new Dog(LocalDate.of(2020, 1, 1)));
        var repo = new AnimalRepositoryImpl();
        var result = repo.findAverageAge(dogs);
        System.out.println("Avg Age: " + result);

        List<AnimalAbstract> animals = new ArrayList<AnimalAbstract>();
        animals.add(new Dog(LocalDate.of(2023, 1, 1), 20.0));
        animals.add(new Cat(LocalDate.of(2012, 1, 1), 50.0));
        animals.add(new Cat(LocalDate.of(2015, 1, 1), 60.0));
        animals.add(new Cat(LocalDate.of(2022, 1, 1), 60.0));
        animals.add(new Wolf(LocalDate.of(2020, 1, 1), 30.0));
        animals.add(new Cat(LocalDate.of(2020, 1, 1), 40.0));
        animals.add(new Shark(LocalDate.of(2020, 1, 1), 10.0));

        var minCostResult = repo.findMinCost(animals);
        for (var animal : minCostResult) {
            System.out.println(animal);
        }

        var animalResult = repo.findOldAndExpensive(animals);
        for (var animal : animalResult) {
            System.out.println(animal.getName() + animal.getBirdthDate());
        }

        task8Parallel();
    }

    private static void task8Parallel() throws ExecutionException, InterruptedException {
        var counter = new CounterImpl();
        var executor = Executors.newFixedThreadPool(10);

        executor.execute(() -> {
            try {
                Thread.sleep(400);
            } catch (Exception ex) {
            }
            counter.Increment();
            System.out.println("Task1");
        });
        executor.execute(() -> {
            counter.Increment();
            System.out.println("Task2");
        });
        executor.execute(() -> {
            try {
                Thread.sleep(500);
            } catch (Exception ex) {
            }
            counter.Increment();
            System.out.println("Task3");
        });
        executor.execute(() -> {
            try {
                Thread.sleep(100);
            } catch (Exception ex) {
            }
            counter.Increment();
            System.out.println("Task4");
        });
        executor.execute(() -> {
            counter.Increment();
            System.out.println("Task5");
        });
        System.out.println("Counter:" + counter.GetValue());

        executor.shutdown();
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);

        System.out.println("Counter after wait:" + counter.GetValue());


        executor = Executors.newFixedThreadPool(10);
        List<Future<?>> futures = new ArrayList<Future<?>>();
        for (int i = 0; i < 10; i++) {
            futures.add(executor.submit(runnableWithParam(i)));
        }
        futures.forEach(f -> {
            try {
                f.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();

        executor = Executors.newFixedThreadPool(10);
        List<Future<?>> results = new ArrayList<Future<?>>();
        for (int i = 0; i < 10; i++) {
            results.add(getPrimeNumber(executor, i * 100, (i + 1) * 100 - 1));
        }

        results.forEach(result -> {
            try {
                var array = (List<Integer>) result.get();
                for (Integer prime : array) {
                    System.out.println(prime);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        });
        executor.shutdown();
    }

    private static Runnable runnableWithParam(final int i) {
        return new Runnable() {
            @Override
            public void run() {
                var rnd = new Random();
                int genResult = rnd.nextInt(100);
                System.out.println("Task " + i + ", generation result:" + genResult);
            }
        };
    }

    private static Future<?> getPrimeNumber(ExecutorService executor, final int rangeStart, final int rangeEnd) {
        var future = executor.submit(() -> {
            ArrayList<Integer> lst = new ArrayList<Integer>();
            for (int i = rangeStart; i < rangeEnd; i++) {
                boolean prime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    lst.add(i);
                }
            }

            return lst;
        });

        return future;
    }
}
