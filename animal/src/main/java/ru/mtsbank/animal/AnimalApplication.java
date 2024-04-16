package ru.mtsbank.animal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import ru.mtsbank.animal.animals.Wolf;

import java.time.LocalDate;

@SpringBootApplication
public class AnimalApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(AnimalApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Hello world");
        var ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        var wolf = ctx.getBean(Wolf.class);
        System.out.println(wolf.toString());

    }
}
