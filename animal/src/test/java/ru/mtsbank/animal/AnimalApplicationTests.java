package ru.mtsbank.animal;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import ru.mtsbank.animal.animals.AnimalAbstract;
import ru.mtsbank.animal.animals.Cat;
import ru.mtsbank.animal.animals.Dog;
import ru.mtsbank.animal.animals.Wolf;
import ru.mtsbank.animal.services.AnimalRepositoryImpl;
import ru.mtsbank.animal.services.CreateAnimalServiceImpl;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@TestPropertySource("classpath:application-test.properties")
class AnimalApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private Wolf wolf;

	@Autowired
	private CreateAnimalServiceImpl createImpl;

	@Autowired
	private AnimalRepositoryImpl animalRepoImpl;
	@Test
	void wolfCreated() {
		assertThat(wolf).isNotNull();
	}

	@Test
	void wolfName() {
		assertThat(wolf.getName()).contains("Test");
	}

	@Test
	void wolfBadTest() {
		assertThat(wolf.getName()).contains("Test1");
	}

	@Test
	void animalRepoImplCreatedBad() {
		assertThat(animalRepoImpl).isNull();
	}

	@Test
	void createImplTest() {
		var hashMap = createImpl.createAnimalsRandom(50);

		int count = 0;
		for (var entry : hashMap.entrySet()) {
			count = count + entry.getValue().size();
		}
		assertThat(count).isEqualTo(50);
	}

	@Test
	public void findLeapYearNames() {

		var animals = new ArrayList<AnimalAbstract>();
		animals.add(new Dog(LocalDate.of(2024, 1, 1)));

		var result = animalRepoImpl.findLeapYearNames(animals);
		assertThat(result.size()).isEqualTo(1);
		assertThat(animals.get(0).getBirdthDate()).isEqualTo(result.values().iterator().next());
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
		assertThat(result.size()).isEqualTo(1);
		assertThat(oldWolf.getBirdthDate()).isEqualTo(result.keySet().iterator().next().getBirdthDate());
	}

	@Test
	public void findOlderAnimalBad() {
		var animalRepository = new AnimalRepositoryImpl();
		var animals = new ArrayList<AnimalAbstract>();
		var oldWolf = new Wolf(LocalDate.of(200, 11, 1),50.0,"Волк","Полярник");
		animals.add(new Dog(LocalDate.of(2024, 1, 1)));
		animals.add(new Dog(LocalDate.of(2023, 1, 1)));
		animals.add(oldWolf);
		animals.add(new Cat(LocalDate.of(2023, 1, 1)));

		var result = animalRepository.findOlderAnimal(animals, 2000);
		assertThat(result.size()).isEqualTo(1);
	}
}
