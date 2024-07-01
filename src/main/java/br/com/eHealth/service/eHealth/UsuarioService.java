package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

import java.util.List;

public class UsuarioService<T extends UsuarioDTO> {

    protected UsuarioStrategy<T> strategy;

    public UsuarioService(UsuarioStrategy<T> strategy) {
        this.strategy = strategy;
    }

    public T criar(T usuarioDTO) {
        return this.strategy.criar(usuarioDTO);
    }

    public T atualizar(T usuarioDTO, Long id) {
        return this.atualizar(usuarioDTO, id);
    }

    public Boolean deletar(Long id) {
        return this.strategy.deletar(id);
    }

    public T buscarPorId(Long id) {
        return this.strategy.buscarPorId(id);
    }

    public List<T> buscarTodos() {
        return this.strategy.buscarTodos();
    }

    public Boolean login(String login, String senha) {
        return this.strategy.login(login, senha);
    }

    public Boolean existe(Long id, String cpf, String login, String email) {
        return this.strategy.existe(id, cpf, login, email);
    }
}
