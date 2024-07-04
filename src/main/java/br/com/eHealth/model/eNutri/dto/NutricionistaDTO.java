/*
* NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
* */

package br.com.eHealth.model.eNutri.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eNutri.Nutricionista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class NutricionistaDTO extends ProfissionalDTO{

    @JsonProperty("crn")
    private Optional<String> CRN;

    public NutricionistaDTO(Nutricionista nutricionistaConsultado) {
        super(nutricionistaConsultado);
        this.CRN = Optional.ofNullable(nutricionistaConsultado.getCRN());
    }
}
