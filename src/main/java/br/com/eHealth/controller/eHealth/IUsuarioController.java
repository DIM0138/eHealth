package br.com.eHealth.controller.eHealth;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

public abstract interface IUsuarioController<T extends UsuarioDTO> {

    public abstract T criar(@RequestBody T usuarioDTO);
    public abstract T atualizar(@RequestBody T usuarioDTO, @PathVariable Long id);
    public abstract Boolean deletar(@PathVariable Long id);
    public abstract T buscarPorId(@PathVariable Long id);
    public abstract List<T> buscarTodos();
    public abstract Boolean login(@RequestParam("login") String login, @RequestParam("senha") String senha);
    public abstract Boolean existe(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "cpf", required = false) String cpf,
                                   @RequestParam(value = "login", required = false) String login,
                                   @RequestParam(value = "email", required = false) String email);
}
