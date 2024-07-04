package br.com.eHealth.model.eNutri;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
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
