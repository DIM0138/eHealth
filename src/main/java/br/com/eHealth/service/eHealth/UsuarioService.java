package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

import java.util.List;

public class UsuarioService {

    protected UsuarioStrategy strategy;

    public UsuarioService(UsuarioStrategy strategy) {
        this.strategy = strategy;
    }

    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {
        return this.strategy.criar(usuarioDTO);
    }

    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO, Long id) {
        return this.atualizar(usuarioDTO, id);
    }

    public Boolean deletar(Long id) {
        return this.strategy.deletar(id);
    }

    public UsuarioDTO buscarPorId(Long id) {
        return this.strategy.buscarPorId(id);
    }

    public List<UsuarioDTO> buscarTodos() {
        return this.strategy.buscarTodos();
    }

    public Boolean login(String login, String senha) {
        return this.strategy.login(login, senha);
    }

    public Boolean existe(Long id, String cpf, String login, String email) {
        return this.strategy.existe(id, cpf, login, email);
    }
}
