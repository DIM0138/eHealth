/*
* NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
* */

package br.com.eHealth.model.dto;

import br.com.eHealth.model.Nutricionista;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class NutricionistaDTO extends ProfissionalDTO{
    private String CRN;

    public NutricionistaDTO() {}

    public NutricionistaDTO(Nutricionista nutricionistaConsultado) {
        super(nutricionistaConsultado);
        this.CRN = nutricionistaConsultado.getCRN();
    }
}
