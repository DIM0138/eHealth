package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.Prescricao;
import br.com.eHealth.model.eEndo.dto.PrescricaoDTO;
import br.com.eHealth.service.eHealth.TratamentoStrategy;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class PrescricaoStrategy extends TratamentoStrategy<Prescricao, PrescricaoDTO> {

    @Override
    public ArrayList<String> validateMandatoryFieldImp(PrescricaoDTO prescricaoDTO, ArrayList<String> errors) {
        if (prescricaoDTO.getDosagem() == 0) {
            errors.add("A dosagem deve ser informada");
        }

        if (prescricaoDTO.getInstrucoes() == null || prescricaoDTO.getInstrucoes().isEmpty()) {
            errors.add("Instruções devem ser informadas");
        }

        return errors;
    }

    @Override
    public ArrayList<String> validateFieldConstraintsImp(PrescricaoDTO tratamentoDTO, ArrayList<String> errors) {
        return errors;
    }
}
