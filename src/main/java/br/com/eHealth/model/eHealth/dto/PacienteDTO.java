package br.com.eHealth.model.eHealth.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.Paciente;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
@NoArgsConstructor
public class PacienteDTO extends UsuarioDTO {

    @JsonProperty("profissional_responsavel")
    private Optional<Long> profissionalResponsavel;

    @JsonProperty("plano_atual")
    private Optional<Long> planoAtual;
    
    public PacienteDTO(Paciente paciente) {
        super(paciente);
        this.profissionalResponsavel = Optional.ofNullable(paciente.getProfissionalResponsavel().getId());
        this.planoAtual = Optional.ofNullable(paciente.getPlanoAtual().getId());
    }
}
