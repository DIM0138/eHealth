package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.RegistroDiario;
import jakarta.persistence.Entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
public class RegistroDiarioRefeicao extends RegistroDiario {
    
}
