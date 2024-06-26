package br.com.eHealth.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIdentityInfo(scope = Usuario.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Profissional extends Usuario {

    private String formacao;

    private String especialidade;

    private String enderecoProfissional;

    @OneToMany(mappedBy = "profissionalResponsavel", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Paciente> listaPacientes = new ArrayList<>();

    public Profissional() {
        this.formacao = "";
        this.especialidade = "";
        this.enderecoProfissional = "";
    }
}
