package br.com.eHealth.model.eHealth;

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
public class Paciente extends Usuario{

    @ManyToOne
    private Profissional profissionalResponsavel;

    @OneToOne
    @JoinColumn(name = "plano_atual_id")
    private Plano planoAtual;
}
