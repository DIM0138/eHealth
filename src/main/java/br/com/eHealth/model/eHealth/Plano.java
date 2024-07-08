package br.com.eHealth.model.eHealth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Plano {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissionalResponsavel;

    @JsonIgnore
    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroDiario> registrosDiarios;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @Builder.Default
    private Boolean ativo = false;

    public Plano() {
        this.registrosDiarios = new ArrayList<RegistroDiario>();
    }

    public Plano(PlanoBuilder builder) {
        this.profissionalResponsavel = builder.profissionalResponsavel;
    }

    public RegistroDiario getRegistroDiarioByDate(LocalDate data) {
        for (RegistroDiario registroDiario : this.registrosDiarios) {
            if (registroDiario.getData().equals(data)) {
                return registroDiario;
            }
        }
        return null;
    }

    public void addRegistroDiario(RegistroDiario registroDiario) {
        this.registrosDiarios.add(registroDiario);
    }

    public static PlanoBuilder builder() {
        return new PlanoBuilder();
    }

    public static class PlanoBuilder {
        private Profissional profissionalResponsavel;

        public PlanoBuilder profissional(Profissional profissional) {
            this.profissionalResponsavel = profissional;
            return this;
        }

        public Plano build() {
            return new Plano(this);
        }
    }

    public PlanoDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        PlanoDTO planoDTO = objectMapper.convertValue(this, PlanoDTO.class);

        List<RegistroDiarioDTO> registrosDiarios = this.getRegistrosDiarios()
                .stream()
                .map(RegistroDiario::toDTO)
                .toList();

        planoDTO.setPaciente(this.paciente.getId());
        planoDTO.setProfissionalResponsavel(this.profissionalResponsavel.getId());
        planoDTO.setRegistrosDiarios(registrosDiarios);

        return planoDTO;
    }
}
