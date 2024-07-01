package br.com.eHealth.model.eHealth;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Profissional extends Usuario {

    @OneToMany(mappedBy = "profissionalResponsavel", cascade = CascadeType.ALL)
    private List<Paciente> listaPacientes;

    private String formacao;
    private String especialidade;
    private String enderecoProfissional;

    public Profissional() {
        this.formacao = "";
        this.especialidade = "";
        this.enderecoProfissional = "";
    }
}
