package br.com.eHealth.model.eHealth;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class RegistroDiario {

    public enum QualidadeSono {
        EXCELENTE,
        BOM,
        REGULAR,
        RUIM,
        PESSIMO,
        PENDENTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    private LocalDate data;

    @ElementCollection
    private List<String> sintomas;

    @Enumerated(EnumType.STRING)
    private QualidadeSono qualidadeSono = QualidadeSono.PENDENTE;

    public RegistroDiario() {
        this.sintomas = new ArrayList<String>();
    }

    public void addSintoma(String sintoma) {
        this.sintomas.add(sintoma);
    }

    public void addListaSintomas(List<String> sintomas) {
        this.sintomas.addAll(sintomas);
    }
}
