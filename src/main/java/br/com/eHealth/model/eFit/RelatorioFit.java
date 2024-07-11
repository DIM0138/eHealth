package br.com.eHealth.model.eFit;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.Relatorio;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class RelatorioFit extends Relatorio{

    @JsonProperty("peso")
    @Column(nullable = false)
    private double peso;

    @JsonProperty("percentual_gordura")
    @Column(nullable = false)
    private double percentualGordura;
}
