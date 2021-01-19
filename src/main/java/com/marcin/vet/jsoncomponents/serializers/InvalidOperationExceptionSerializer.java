package com.marcin.vet.jsoncomponents.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.marcin.vet.exeptions.InvalidOperationException;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

public class InvalidOperationExceptionSerializer extends StdSerializer<InvalidOperationException> {

    public InvalidOperationExceptionSerializer() {
        this(null);
    }

    public InvalidOperationExceptionSerializer(Class<InvalidOperationException> e) {
        super(e);
    }

    @Override
    public void serialize(InvalidOperationException value, JsonGenerator gen, SerializerProvider provider) throws IOException {

        gen.writeStartObject();

        gen.writeNumberField("status", 406);
        gen.writeStringField("message", value.getMessage());
        gen.writeStringField("timestamp", value.getExceptionTime().format(DateTimeFormatter.ofPattern("YYYY-MM-dd HH:mm:ss")));

        gen.writeEndObject();
    }
}