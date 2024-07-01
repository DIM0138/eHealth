package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.Profissional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Nutricionista extends Profissional {

    @Column(nullable = false, unique = true)
    private String CRN;

}
