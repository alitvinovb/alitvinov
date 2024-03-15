package ru.mtsbank.Interfaces;


import java.time.LocalDate;

public interface Animal {
    public String getBreed();

    public String getName();

    public Double getCost();

    public String getCharacter();

    public LocalDate getBirdthDate();
}
