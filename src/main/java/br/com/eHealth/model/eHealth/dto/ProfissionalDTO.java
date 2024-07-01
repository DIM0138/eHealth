package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eHealth.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProfissionalDTO extends UsuarioDTO{

    private String formacao;
    private String especialidade;
    private String enderecoProfissional;

    public ProfissionalDTO(Profissional profissional) {
        super(profissional);
        this.formacao = profissional.getFormacao();
        this.especialidade = profissional.getEspecialidade();
        this.enderecoProfissional = profissional.getEnderecoProfissional();
    }
}
