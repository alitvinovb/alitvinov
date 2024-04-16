package ru.mtsbank.animal.customSerialize;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import ru.mtsbank.animal.animals.*;

import java.io.IOException;
import java.util.Base64;

public class AnimalSerializer extends StdSerializer<AnimalAbstract> {

    public AnimalSerializer() {
        this(null);
    }

    public AnimalSerializer(Class<AnimalAbstract> t) {
        super(t);
    }

    @Override
    public void serialize(
            AnimalAbstract value, JsonGenerator jgen, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        jgen.writeStartObject();
        jgen.writeStringField("breed", value.getBreed());
        jgen.writeStringField("name", value.getName());
        jgen.writeNumberField("cost", value.getCost());
        jgen.writeStringField("character", value.getCharacter());
        jgen.writeStringField("birdthDate", value.getBirdthDate().toString());
        jgen.writeStringField("secretInformation", Base64.getEncoder().encodeToString(value.getSecretInformation().getBytes()));
        jgen.writeEndObject();
    }
}