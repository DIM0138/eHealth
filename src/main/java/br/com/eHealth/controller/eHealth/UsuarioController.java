package br.com.eHealth.controller.eHealth;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.eHealth.model.eHealth.Usuario;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.service.eHealth.UsuarioService;

public class UsuarioController<T extends Usuario, DTO extends UsuarioDTO> {

    @Autowired
    public UsuarioService<T, DTO> usuarioService;

    @PostMapping
    public UsuarioDTO criar(@RequestBody DTO usuarioDTO) {
        return this.usuarioService.criar(usuarioDTO);
    }

    @PatchMapping("/{id}")
    public UsuarioDTO atualizar(@RequestBody DTO usuarioDTO, @PathVariable Long id) {
        return this.usuarioService.atualizar(usuarioDTO, id);
    }

    @DeleteMapping("/{id}")
    public Boolean deletar(@PathVariable Long id) {
        return this.usuarioService.deletar(id);
    }

    @GetMapping("/{id}")
    public UsuarioDTO buscarPorId(@PathVariable Long id) {
        return this.usuarioService.buscarPorId(id).toDTO();
    }

    @GetMapping("/todos")
    public List<UsuarioDTO> buscarTodos() {
        return this.usuarioService.buscarTodos();
    }

    @GetMapping("/login")
    public Boolean login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return this.usuarioService.login(login, senha);
    }
}