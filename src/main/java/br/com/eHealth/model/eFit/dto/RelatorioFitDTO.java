package br.com.eHealth.model.eFit.dto;

import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

@Data
@EqualsAndHashCode(callSuper = false)
public class RelatorioFitDTO extends RelatorioDTO {

    @JsonProperty("peso")
    private Optional<Double> peso;

    @JsonProperty("percentual_gordura")
    private Optional<Double> percentualGordura;
}
