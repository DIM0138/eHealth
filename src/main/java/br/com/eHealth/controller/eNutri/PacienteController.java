package br.com.eHealth.controller.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.service.eNutri.PacienteService;

@RestController
@RequestMapping("/pacientes")
public class PacienteController extends UsuarioController<Paciente, PacienteDTO>{

    @Autowired
    private PacienteService pacienteService;

    @GetMapping("/token")
    public TokenCadastroDTO novoToken(@RequestParam("nomePaciente") String nomePaciente) {

        return this.pacienteService.novoToken(nomePaciente);
    }
    
    @GetMapping("/buscar/{token}")
    public TokenCadastroDTO buscarPorToken(@PathVariable String token) {
        return this.pacienteService.buscarPorToken(token);
    }
    
}
