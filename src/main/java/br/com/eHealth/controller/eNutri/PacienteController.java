package br.com.eHealth.controller.eNutri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;

@RestController
@RequestMapping("/enutri/pacientes")
public class PacienteController extends UsuarioController<Paciente, PacienteDTO>{

}
