package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.Profissional;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Nutricionista extends Profissional {

    @Column(nullable = false, unique = true)
    private String CRN;

}
