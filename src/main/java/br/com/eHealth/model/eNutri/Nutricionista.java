package br.com.eHealth.model.eNutri;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.model.eNutri.serialization.NutricionistaDeserializer;
import br.com.eHealth.model.eNutri.serialization.NutricionistaSerializer;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@JsonIdentityReference(alwaysAsId = true)
public class Nutricionista extends Profissional {

    @Column(nullable = false, unique = true)
    @JsonProperty("crn")
    private String CRN;

    public NutricionistaDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, NutricionistaDTO.class);
    }

}
