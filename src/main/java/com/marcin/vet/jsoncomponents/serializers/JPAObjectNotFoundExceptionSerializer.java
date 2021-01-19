package com.marcin.vet.jsoncomponents.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marcin.vet.exeptions.JPAObjectNotFoundException;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class JPAObjectNotFoundExceptionSerializer extends StdSerializer<JPAObjectNotFoundException> {

    public JPAObjectNotFoundExceptionSerializer() {
        this(null);
    }

    public JPAObjectNotFoundExceptionSerializer(Class<JPAObjectNotFoundException> e) {
        super(e);
    }

    @Override
    public void serialize(JPAObjectNotFoundException value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeStartObject();

        gen.writeNumberField("status", 404);
        gen.writeStringField("message", value.getMessage());
        gen.writeStringField("timestamp", value.getExceptionTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));

        gen.writeEndObject();
    }
}