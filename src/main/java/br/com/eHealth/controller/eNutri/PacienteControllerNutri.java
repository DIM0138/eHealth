package br.com.eHealth.controller.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.service.eHealth.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/enutri/pacientes")
public class PacienteControllerNutri extends UsuarioController<Paciente, PacienteDTO>{

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/profissional/{id}")
    public List<PacienteDTO> buscarPacientesPorProfissionalId(@PathVariable Long id) {
        return this.pacienteService.buscarPorProfissionalId(id);
    }

    
}
