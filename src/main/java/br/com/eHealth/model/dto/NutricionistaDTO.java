package br.com.eHealth.model.dto;

import java.util.List;

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
