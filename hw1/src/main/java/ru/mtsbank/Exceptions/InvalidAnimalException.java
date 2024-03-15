package ru.mtsbank.Exceptions;

public class InvalidAnimalException extends Exception {
    public InvalidAnimalException(String errorMessage) {
        super(errorMessage);
    }
}