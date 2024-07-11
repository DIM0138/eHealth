package br.com.eHealth.service.eNutri;

import org.springframework.stereotype.Service;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.service.eHealth.UsuarioService;

@Service
public class PacienteService extends UsuarioService<Paciente, PacienteDTO> {

}
