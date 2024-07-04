package br.com.eHealth.model.eHealth.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString(callSuper = true)
public class ProfissionalDTO extends UsuarioDTO{

    @JsonProperty("formacao")
    private Optional<String> formacao;

    @JsonProperty("especialidade")
    private Optional<String> especialidade;

    @JsonProperty("endereco_profissional")
    private Optional<String> enderecoProfissional;

    public ProfissionalDTO(Profissional profissional) {
        super(profissional);
        this.formacao = Optional.ofNullable(profissional.getFormacao());
        this.especialidade = Optional.ofNullable(profissional.getEspecialidade());
        this.enderecoProfissional = Optional.ofNullable(profissional.getEnderecoProfissional());
    }
}
