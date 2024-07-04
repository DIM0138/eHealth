package br.com.eHealth.model.eNutri.serialization;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.service.eNutri.NutricionistaService;

@Component
public class NutricionistaDeserializer extends StdDeserializer<Nutricionista> {

    @Autowired
    NutricionistaService nutricionistaService;

    public NutricionistaDeserializer() {
        this(null);
    }

    public NutricionistaDeserializer(Class<Nutricionista> t) {
        super(t);
    }

    @Override
    public Nutricionista deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        Long id = p.getLongValue();
        return nutricionistaService.buscarPorId(id);
    }

}
