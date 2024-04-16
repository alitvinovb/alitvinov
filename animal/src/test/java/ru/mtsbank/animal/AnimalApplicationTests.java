package ru.mtsbank.animal;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.mtsbank.animal.animals.Wolf;
import ru.mtsbank.animal.services.CreateAnimalServiceImpl;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class AnimalApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private Wolf wolf;

	@Autowired
	private CreateAnimalServiceImpl createImpl;
	@Test
	void wolfCreated() {
		assertThat(wolf).isNotNull();
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
}
