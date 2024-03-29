package ru.mtsbank.Services;

import ru.mtsbank.Interfaces.Counter;

import java.util.concurrent.atomic.AtomicInteger;

public class CounterImpl implements Counter {
    private AtomicInteger value;

    public CounterImpl() {
        value = new AtomicInteger();
    }
    public void Increment(){
        value.incrementAndGet();
    }

    public int GetValue(){
        return value.get();
    }
}
