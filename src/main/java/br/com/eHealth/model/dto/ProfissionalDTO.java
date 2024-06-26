package br.com.eHealth.model.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.eHealth.model.Paciente;
import br.com.eHealth.model.Profissional;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class ProfissionalDTO extends UsuarioDTO{

    private String formacao;
    private String especialidade;
    private String enderecoProfissional;
    private List<Long> listaPacientesIds;

    public ProfissionalDTO() {}

    public ProfissionalDTO(Profissional profissional) {
        super(profissional);
        this.formacao = profissional.getFormacao();
        this.especialidade = profissional.getEspecialidade();
        this.enderecoProfissional = profissional.getEnderecoProfissional();
        this.listaPacientesIds = profissional.getListaPacientes().stream().map(Paciente::getId).toList();
    }
}
