package br.com.eHealth.model.eNutri;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Ingrediente {

    public enum TipoMedida {
        QUILOS,
        GRAMAS,
        LITROS,
        MILILITROS,
        XICARAS,
        COLHER_DE_SOPA,
        COLHER_DE_CHA,
        UNIDADE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoMedida medida;

    @PrePersist
    private void nomeUpperCase() {
        nome = nome.toUpperCase();
    }
}
