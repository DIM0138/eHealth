package br.com.eHealth.model.eHealth;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
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

    @OneToMany(mappedBy = "plano", cascade = CascadeType.ALL)
    private List<RegistroDiario> registrosDiarios;

    private LocalDate dataInicio;

    private LocalDate dataFim;

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
}
