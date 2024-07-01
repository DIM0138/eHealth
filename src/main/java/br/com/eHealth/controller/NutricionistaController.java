/*
 * NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
 * */
package br.com.eHealth.controller;

import br.com.eHealth.controller.eHealth.IProfissionalController;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.service.eNutri.NutricionistaService;
import br.com.eHealth.service.eNutri.NutricionistaStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController implements IProfissionalController {

    private final NutricionistaService nutricionistaService;

    public NutricionistaController(@Autowired NutricionistaStrategy nutricionistaStrategy) {
        this.nutricionistaService = new NutricionistaService(nutricionistaStrategy);
    }

    @Override
    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
        return this.nutricionistaService.criar(usuarioDTO);
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO, Long id) {
        return this.nutricionistaService.atualizar(usuarioDTO, id);
    }

    @Override
    public Boolean deletar(Long id) {
        return this.nutricionistaService.deletar(id);
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        return this.nutricionistaService.buscarPorId(id);
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
        return this.nutricionistaService.buscarTodos();
    }

    @Override
    public Boolean login(String login, String senha) {
        return this.nutricionistaService.login(login, senha);
    }

    @Override
    public Boolean existe(Long id, String cpf, String login, String email) {
        return this.nutricionistaService.existe(id, cpf, login, email);
    }

    @Override
    public List<PacienteDTO> buscarPacientesPorProfissionalId(Long id) {
        return this.nutricionistaService.buscarPacientesPorProfissional(id);
    }
}
