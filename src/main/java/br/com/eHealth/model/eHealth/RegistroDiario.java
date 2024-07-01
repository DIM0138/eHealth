package br.com.eHealth.model.eHealth;

import jakarta.persistence.CascadeType;
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
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RegistroDiario {

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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<Tratamento> tratamentos = new ArrayList<Tratamento>();

    private LocalDate data;

    @ElementCollection
    @Builder.Default
    private List<String> sintomas = new ArrayList<String>();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private QualidadeSono qualidadeSono = QualidadeSono.PENDENTE;

    public void addSintoma(String sintoma) {
        this.sintomas.add(sintoma);
    }

    public void addListaSintomas(List<String> sintomas) {
        this.sintomas.addAll(sintomas);
    }
}
