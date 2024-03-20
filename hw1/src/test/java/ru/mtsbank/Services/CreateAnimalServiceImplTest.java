package ru.mtsbank.Services;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreateAnimalServiceImplTest {

    @Test
    public void createAnimalsRandom() {
        var service = new CreateAnimalServiceImpl();
        var hashMap = service.createAnimalsRandom(50);

        int count = 0;
        for (var entry : hashMap.entrySet()) {
            count = count + entry.getValue().size();
        }

        Assert.assertEquals(50, count);
    }
}