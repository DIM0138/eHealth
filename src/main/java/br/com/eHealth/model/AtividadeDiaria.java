package br.com.eHealth.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;

@Data
@Entity
public class AtividadeDiaria {
    public enum Emocao {
        FELIZ,
        TRISTE,
        NEUTRO,
        ESTRESSADO,
        ANSIOSO,
        PENDENTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private Emocao emocao = Emocao.PENDENTE;

    private Boolean atividadeFeita;

}
