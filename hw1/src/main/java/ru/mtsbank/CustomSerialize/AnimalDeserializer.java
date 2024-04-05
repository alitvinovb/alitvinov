package ru.mtsbank.CustomSerialize;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.node.DoubleNode;
import ru.mtsbank.Animals.AnimalAbstract;
import ru.mtsbank.Animals.AnimalNonAbstract;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Base64;

public class AnimalDeserializer extends StdDeserializer<AnimalAbstract> {

    public AnimalDeserializer() {
        this(null);
    }

    public AnimalDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public AnimalAbstract deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException, JsonProcessingException {
        JsonNode node = jp.getCodec().readTree(jp);
        String name = node.get("name").asText();
        String breed = node.get("breed").asText();
        String character = node.get("character").asText();
        String secretInformation = "";
        try {
            secretInformation = new String(Base64.getDecoder().decode(node.get("secretInformation").asText()));
        } catch (Exception ex) {
        }
        Double cost = (Double) ((DoubleNode) node.get("cost")).numberValue();
        String bDay = node.get("birdthDate").asText();

        return new AnimalNonAbstract(LocalDate.parse(bDay), cost, breed, name, secretInformation);
    }
}

