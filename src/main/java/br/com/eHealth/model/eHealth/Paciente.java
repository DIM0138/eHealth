package br.com.eHealth.model.eHealth;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Paciente extends Usuario{

    @ManyToOne
    private Profissional profissionalResponsavel;

    @OneToOne
    @JoinColumn(name = "plano_atual_id")
    private Plano planoAtual;
}
