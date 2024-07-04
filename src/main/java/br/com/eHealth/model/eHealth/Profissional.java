package br.com.eHealth.model.eHealth;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true)
public abstract class Profissional extends Usuario {

    @JsonProperty("formacao")
    private String formacao;

    @JsonProperty("especialidade")
    private String especialidade;

    @JsonProperty("endereco_profissional")
    private String enderecoProfissional;

    public abstract ProfissionalDTO toDTO();

}
