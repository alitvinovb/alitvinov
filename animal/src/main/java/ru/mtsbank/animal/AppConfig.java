package ru.mtsbank.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import ru.mtsbank.animal.animals.Wolf;
import ru.mtsbank.animal.services.AnimalRepositoryImpl;
import ru.mtsbank.animal.services.CreateAnimalServiceImpl;

import java.time.LocalDate;
import java.util.Random;

@Configuration
@ComponentScan("ru.mtsbank.animal.services")
@PropertySource("classpath:application.properties")

public class AppConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Value("${animalNames}")
    private String[] names;

    /*
    Some solution for read properties:
    @Autowired
    Environment env;
    env.getProperty("spring.application.name")*/

    @Bean()
    @Scope("prototype")
    public Wolf getWolf() {
        var rnd = new Random();
        int index = rnd.nextInt(names.length);

        return new Wolf(LocalDate.of(2024,1,2),names[index]);
    }
}
