package br.com.eHealth.model.eFit.dto;

import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(callSuper = false)
public class RegistroDiarioTreinoDTO extends RegistroDiarioDTO {

    private Optional<Integer> quantidadePassos;
    
}
