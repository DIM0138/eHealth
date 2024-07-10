package br.com.eHealth.service.eFit;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eFit.Instrutor;
import br.com.eHealth.model.eFit.dto.InstrutorDTO;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class InstrutorStrategy extends UsuarioStrategy<Instrutor, InstrutorDTO> {

    @Override
    protected Instrutor usuarioFactory() {
        return new Instrutor();
    }

    @Override
    protected void validateMandatoryFieldsImp(InstrutorDTO usuarioDTO, ArrayList<String> errors) {
        if(usuarioDTO.getCREF() == null || usuarioDTO.getCREF().isEmpty()) {
            errors.add("Um CREF deve ser informado");
        }
    }

    @Override
    protected void validateFieldConstraintsImp(InstrutorDTO usuarioDTO, ArrayList<String> errors) {
        if(usuarioDTO.getCREF() != null && usuarioDTO.getCREF().isPresent() && !usuarioDTO.getCREF().get().matches("\\d{1,6}-[A-Z]\\/[A-Z]{2}")) {
            errors.add("O formato do CREF informado é inválido.");
        }
    }
    
}
