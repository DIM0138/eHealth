package br.com.eHealth.service.eNutri;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class NutricionistaStrategy extends UsuarioStrategy<Nutricionista, NutricionistaDTO> {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Override
    public ArrayList<String> validateSpecifics(ArrayList<String> errors, UsuarioDTO usuarioDTO) {

        NutricionistaDTO nutricionistaDTO = (NutricionistaDTO) usuarioDTO;

        if (nutricionistaDTO.getCRN() == null || nutricionistaDTO.getCRN().isEmpty()) {
            errors.add("Um CRN deve ser informado");
        }

        else if (nutricionistaRepository.existsByCRN(nutricionistaDTO.getCRN().get())) {
            errors.add("O CRN informado já foi cadastrado");
        }
        
        return errors;
    }
    
    @Override
    public Nutricionista saveSpecifics(NutricionistaDTO usuarioDTO, Nutricionista novoUsuario) {
        return nutricionistaRepository.save(novoUsuario);
    }

    @Override
    public Nutricionista usuarioFactory(NutricionistaDTO usuarioDTO) {
        return new Nutricionista();
    }

    
}
