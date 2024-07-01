package br.com.eHealth.model.eNutri.dto;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PacienteDTO extends UsuarioDTO {

    private Long profissionalResponsavelId;
    private Long planoAtualId;
    
    public PacienteDTO(Paciente paciente) {
        super(paciente);
        this.profissionalResponsavelId = paciente.getProfissionalResponsavel().getId();
        this.planoAtualId = paciente.getPlanoAtual().getId();
    }
}
