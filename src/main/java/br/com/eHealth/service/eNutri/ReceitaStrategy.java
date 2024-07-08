package br.com.eHealth.service.eNutri;

import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import br.com.eHealth.repository.eNutri.ReceitaRepository;
import br.com.eHealth.service.eHealth.TratamentoStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ReceitaStrategy extends TratamentoStrategy<Receita, ReceitaDTO> {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Override
    public ArrayList<String> validateMandatoryFieldImp(ReceitaDTO receitaDTO, ArrayList<String> errors) {
        if (receitaDTO.getTipoRefeicao() == null) {
            errors.add("Um tipo de refeição deve ser informado");
        }

        if (receitaDTO.getTempoPreparo() == 0) {
            errors.add("Um tempo de preparo deve ser informado");
        }

        if (receitaDTO.getModoPreparo() == null || receitaDTO.getModoPreparo().isEmpty()) {
            errors.add("O modo de preparo deve ser informado");
        }

        if (receitaDTO.getIngredientes() == null || receitaDTO.getIngredientes().isEmpty()) {
            errors.add("Os ingredientes devem ser informados");
        }

        if (receitaDTO.getContemAlergicos() == null) {
            errors.add("Contém alergicos ser informado");
        }

        return errors;
    }

    @Override
    public ArrayList<String> validateFieldConstraintsImp(ReceitaDTO receitaDTO, ArrayList<String> errors) {
        if (receitaDTO.getContemAlergicos() && (receitaDTO.getAlergicos() == null || receitaDTO.getAlergicos().isEmpty())){
            errors.add("Os alergicos devem ser informados");
        }

        return errors;
    }
}
