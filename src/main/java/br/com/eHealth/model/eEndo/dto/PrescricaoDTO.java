package br.com.eHealth.model.eEndo.dto;

import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrescricaoDTO extends TratamentoDTO {
    private double dosagem;
    private String efeitosColaterais;
    private String instrucoes;
}
