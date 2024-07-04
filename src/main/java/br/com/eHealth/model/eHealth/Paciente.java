package br.com.eHealth.model.eHealth;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Inheritance(strategy = InheritanceType.JOINED)
@ToString(callSuper = true)
public  class Paciente extends Usuario{

    @ManyToOne
    @JsonIgnore
    private Profissional profissionalResponsavel;

    @OneToOne
    @JoinColumn(name = "plano_atual_id")
    @JsonIgnore
    private Plano planoAtual;

    @Override
    public PacienteDTO toDTO () {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        PacienteDTO pacienteDTO = objectMapper.convertValue(this, PacienteDTO.class);
        
        if(this.profissionalResponsavel != null){
            pacienteDTO.setProfissionalResponsavel(Optional.ofNullable(this.profissionalResponsavel.getId()));
        }

        if(this.planoAtual != null){
            pacienteDTO.setPlanoAtual(Optional.ofNullable(this.planoAtual.getId()));
        }
        return pacienteDTO;
    }
}
