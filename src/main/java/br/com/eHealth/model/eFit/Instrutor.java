package br.com.eHealth.model.eFit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

import br.com.eHealth.model.eFit.dto.InstrutorDTO;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Instrutor extends Profissional {

    @Column(nullable = false, unique = true)
    @JsonProperty("cref")
    private String CREF;

    @JsonProperty("certificacoes")
    private List<String> certificacoes;

    @Override
    public ProfissionalDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, InstrutorDTO.class);
    }
    
}
