package br.com.eHealth.service.eNutri;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class PacienteStrategy extends UsuarioStrategy<Paciente, PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Override
    public ArrayList<String> validateSpecifics(ArrayList<String> errors, UsuarioDTO usuarioDTO) {
        PacienteDTO pacienteDTO = (PacienteDTO) usuarioDTO;

        if (pacienteDTO.getProfissionalResponsavel() == null || pacienteDTO.getProfissionalResponsavel().isEmpty()) {
            errors.add("Um profissional responsável deve ser informado");
        }

        else if (!nutricionistaRepository.existsById(pacienteDTO.getProfissionalResponsavel().get())) {
            errors.add("O profissional responsável informado não existe.");
        }

        return errors;
    }

    @Override
    public Paciente saveSpecifics(PacienteDTO usuarioDTO, Paciente novoUsuario) {
        PacienteDTO pacienteDTO = (PacienteDTO) usuarioDTO;

        Long idNutricionista = pacienteDTO.getProfissionalResponsavel().get();
        Nutricionista nutricionistaResponsavel = nutricionistaRepository.findById(idNutricionista).get();
        novoUsuario.setProfissionalResponsavel(nutricionistaResponsavel);

        return pacienteRepository.save(novoUsuario);
    }
    
    @Override
    public Paciente usuarioFactory(PacienteDTO usuarioDTO) {
        return new Paciente();
    }

}
