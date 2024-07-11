package br.com.eHealth.service.eHealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.repository.eHealth.PacienteRepository;

import java.util.List;
import java.util.ArrayList;


@Service
public class PacienteService extends UsuarioService<Paciente, PacienteDTO> {

    @Autowired
    private PacienteRepository pacienteRepository;

    public List<PacienteDTO> buscarPorProfissionalId(Long idProfissional) {

        List<Paciente> pacientes = this.pacienteRepository.findByProfissionalResponsavelId(idProfissional);

        List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>();
        
        pacientes.stream().forEach(paciente -> {
            pacientesDTO.add(paciente.toDTO());
        });
        
        return pacientesDTO;
    }
}
