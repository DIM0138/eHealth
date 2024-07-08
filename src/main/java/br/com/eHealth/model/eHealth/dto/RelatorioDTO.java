package br.com.eHealth.model.eHealth.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import lombok.Data;


@Data
public class RelatorioDTO {
    
    @JsonProperty("id")
    private Optional<Long> id;

    @JsonProperty("paciente")
    private Optional<Long> paciente;

    @JsonProperty("profissional_responsavel")
    private Optional<Long> profissionalResponsavel;

    @JsonProperty("data_consulta")
    private Optional<LocalDate> dataConsulta;

    @JsonProperty("medicoes")
    private Optional<List<MedicaoRelatorio>> medicoes;
}
