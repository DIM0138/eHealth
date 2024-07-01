package br.com.eHealth.model.eHealth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    private Profissional profissionalResponsavel;

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<RegistroDiario> registrosDiarios;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    @Builder.Default
    private Boolean ativo = false;

    public Plano() {
        this.registrosDiarios = new ArrayList<RegistroDiario>();
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

    public static class PlanoBuilder {
        private Profissional profissionalResponsavel;

        public PlanoBuilder profissional(Profissional profissional) {
            this.profissionalResponsavel = profissional;
            return this;
        }
    }
}
