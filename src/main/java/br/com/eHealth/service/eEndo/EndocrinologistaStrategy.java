package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.Endocrinologista;
import br.com.eHealth.model.eEndo.dto.EndocrinologistaDTO;
import br.com.eHealth.repository.eEndo.EndocrinologistaRepository;
import br.com.eHealth.service.eHealth.UsuarioStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class EndocrinologistaStrategy extends UsuarioStrategy<Endocrinologista, EndocrinologistaDTO> {

    @Autowired
    private EndocrinologistaRepository endocrinologistaRepository;

    @Override
    protected Endocrinologista usuarioFactory() {
        return new Endocrinologista();
    }

    @Override
    protected void validateMandatoryFieldsImp(EndocrinologistaDTO endocrinologistaDTO, ArrayList<String> errors) {
        if (endocrinologistaDTO.getCRM() == null || endocrinologistaDTO.getCRM().isEmpty()){
            errors.add("Um CRM deve ser informado");
        }
    }

    @Override
    protected void validateFieldConstraintsImp(EndocrinologistaDTO endocrinologistaDTO, ArrayList<String> errors) {
        if (endocrinologistaDTO.getCRM() != null && endocrinologistaDTO.getCRM().isPresent() && endocrinologistaRepository.existsByCRM(endocrinologistaDTO.getCRM().get())){
            errors.add("O CRN informado já foi cadastrado");
        }
    }
}
