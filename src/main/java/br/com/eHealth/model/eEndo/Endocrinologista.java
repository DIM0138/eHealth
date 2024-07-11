package br.com.eHealth.model.eEndo;

import br.com.eHealth.model.eEndo.dto.EndocrinologistaDTO;
import br.com.eHealth.model.eHealth.Profissional;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class Endocrinologista extends Profissional {
    @Column(nullable = false, unique = true)
    @JsonProperty("crm")
    private String CRM;

    public EndocrinologistaDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, EndocrinologistaDTO.class);
    }
}
