package br.com.eHealth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.IUsuarioController;
import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.service.eNutri.PacienteService;
import br.com.eHealth.service.eNutri.PacienteStrategy;

import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/pacientes")
public class PacienteController implements IUsuarioController{

    private PacienteService pacienteService;

    public PacienteController(@Autowired PacienteStrategy pacienteStrategy) {
        this.pacienteService = new PacienteService(pacienteStrategy);
    }

    @Override
    @PostMapping
    public UsuarioDTO criar(@RequestBody UsuarioDTO usuarioDTO) {
        return pacienteService.criar(usuarioDTO);
    }

    @Override
    @PatchMapping("/{id}")
    public UsuarioDTO atualizar(@RequestBody UsuarioDTO usuarioDTO, @PathVariable Long id) {
        return pacienteService.atualizar(usuarioDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public Boolean deletar(@PathVariable Long id) {
        return pacienteService.deletar(id);
    }

    @Override
    @GetMapping("/buscar/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return pacienteService.buscarPorId(id);
    }

    @Override
    @GetMapping("/buscar/todos")
    public List<UsuarioDTO> buscarTodos() {
        return pacienteService.buscarTodos();
    }

    @Override
    public Boolean login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return pacienteService.login(login, senha);
    }

    @Override
    public Boolean existe(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "cpf", required = false) String cpf,
                                   @RequestParam(value = "login", required = false) String login,
                                   @RequestParam(value = "email", required = false) String email) {

        return pacienteService.existe(id, cpf, login, email);
    }

    @GetMapping("/token")
    public TokenCadastroDTO novoToken(@RequestParam("nomePaciente") String nomePaciente) {

        return pacienteService.novoToken(nomePaciente);
    }
    
    @GetMapping("/buscar/{token}")
    public TokenCadastroDTO buscarPorToken(@PathVariable String token) {
        return pacienteService.buscarPorToken(token);
    }
    
}
