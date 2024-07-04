package br.com.eHealth.service.eNutri;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class PacienteStrategy extends UsuarioStrategy<Paciente, PacienteDTO> {

    @Override
    public ArrayList<String> validateMandatoryFieldsImp(PacienteDTO pacienteDTO, ArrayList<String> errors) {

        return errors;
    }

    @Override
    public ArrayList<String> validateFieldConstraintsImp(PacienteDTO pacienteDTO, ArrayList<String> errors) {

        return errors;
    }
    
    @Override
    public Paciente usuarioFactory() {
        return new Paciente();
    }

}
