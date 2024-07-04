package br.com.eHealth.model.eNutri.serialization;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import br.com.eHealth.model.eNutri.Nutricionista;

public class NutricionistaSerializer extends JsonSerializer<Nutricionista> {

    @Override
    public void serialize(Nutricionista value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeNumber(value.getId());
    }
}
