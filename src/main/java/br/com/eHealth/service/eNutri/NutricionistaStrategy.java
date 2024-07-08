package br.com.eHealth.service.eNutri;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class NutricionistaStrategy extends UsuarioStrategy<Nutricionista, NutricionistaDTO> {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Override
    public void validateMandatoryFieldsImp(NutricionistaDTO nutricionistaDTO, ArrayList<String> errors) {
        
        if (nutricionistaDTO.getCRN() == null || nutricionistaDTO.getCRN().isEmpty()) {
            errors.add("Um CRN deve ser informado");
        }

    }
    @Override
    public void validateFieldConstraintsImp(NutricionistaDTO nutricionistaDTO, ArrayList<String> errors) {

        if (nutricionistaDTO.getCRN() != null && nutricionistaDTO.getCRN().isPresent() && nutricionistaRepository.existsByCRN(nutricionistaDTO.getCRN().get())) {
            errors.add("O CRN informado já foi cadastrado");
        }
        
    }

    @Override
    public Nutricionista usuarioFactory() {
        return new Nutricionista();
    }

    
}
