package ru.mtsbank.Exceptions;

public class InvalidAnimalBirthDateException extends Exception {
    public InvalidAnimalBirthDateException(String errorMessage) {
        super(errorMessage);
    }
}
