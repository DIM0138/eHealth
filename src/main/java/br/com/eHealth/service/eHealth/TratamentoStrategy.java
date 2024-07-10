package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public abstract class TratamentoStrategy<T extends Tratamento, DTO extends TratamentoDTO> {

    public final void validateMandatoryFields(DTO tratamentoDTO, ArrayList<String> errors){
        if (tratamentoDTO.getNome() == null || tratamentoDTO.getNome().isEmpty()){
            errors.add("Um nome deve ser informado");
        }

        if (tratamentoDTO.getDescricao() == null || tratamentoDTO.getDescricao().isEmpty()){
            errors.add("Uma descrição deve ser informada");
        }

        validateMandatoryFieldImp(tratamentoDTO, errors);
    }

    public final void validateFieldConstraints(DTO tratamentoDTO, ArrayList<String> errors){
        validateFieldConstraintsImp(tratamentoDTO, errors);
    }

    public final ArrayList<String> validateCreateTratamento(DTO tratamentoDTO){
        ArrayList<String> errors = new ArrayList<>();

        validateMandatoryFields(tratamentoDTO, errors);

        if (!errors.isEmpty()){
            return errors;
        }

        validateFieldConstraints(tratamentoDTO, errors);

        return errors;
    }

    public ArrayList<String> validateUpdateTratamento(DTO tratamentoDTO) {
        ArrayList<String> errors = new ArrayList<String>();

        validateMandatoryFields(tratamentoDTO, errors);

        if (!errors.isEmpty()){
            return errors;
        }

        validateFieldConstraints(tratamentoDTO, errors);

        return errors;
    }

    public abstract void validateMandatoryFieldImp(DTO tratamentoDTO, ArrayList<String> errors);

    public abstract void validateFieldConstraintsImp(DTO tratamentoDTO, ArrayList<String> errors);

    public abstract T saveImp(DTO tratamentoDTO, T novoTratamento);

}
