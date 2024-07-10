package br.com.eHealth.model.eFit;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eFit.dto.RegistroDiarioTreinoDTO;
import br.com.eHealth.model.eHealth.RegistroDiario;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class RegistroDiarioTreino extends RegistroDiario {

    @JsonProperty("quantidade_passos")
    private int quantidadePassos;

    public RegistroDiarioTreinoDTO convertToDTO() {
        RegistroDiarioTreinoDTO registroDiarioTreinoDTO = (RegistroDiarioTreinoDTO) this.toDTO();

        registroDiarioTreinoDTO.setQuantidadePassos(Optional.ofNullable(this.quantidadePassos));

        return registroDiarioTreinoDTO;
    }
}
