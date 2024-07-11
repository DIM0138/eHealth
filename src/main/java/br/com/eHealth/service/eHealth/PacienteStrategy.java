package br.com.eHealth.service.eHealth;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;

@Component
public class PacienteStrategy extends UsuarioStrategy<Paciente, PacienteDTO> {

    @Override
    public void validateMandatoryFieldsImp(PacienteDTO pacienteDTO, ArrayList<String> errors) {

    }

    @Override
    public void validateFieldConstraintsImp(PacienteDTO pacienteDTO, ArrayList<String> errors) {

    }
    
    @Override
    public Paciente usuarioFactory() {
        return new Paciente();
    }

}
