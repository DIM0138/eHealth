package br.com.eHealth.model.eEndo.dto;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EndocrinologistaDTO extends ProfissionalDTO {

    @JsonProperty("crm")
    private Optional<String> CRM;

}
