package ru.mtsbank.animal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.mtsbank.animal.animals.Wolf;

import java.time.LocalDate;

@Configuration
public class AppConfig {
    @Bean(name ="wolf")
    @Scope("prototype")
    public Wolf getWolf() {
        return new Wolf(LocalDate.of(2024,1,2));
    }

}
