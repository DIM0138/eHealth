package br.com.eHealth.service.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

public abstract class UsuarioStrategy<T extends UsuarioDTO> {

    public abstract T criar(T usuarioDTO);
    public abstract T atualizar(T usuarioDTO, Long id);
    public abstract Boolean deletar(Long id);
    public abstract T buscarPorId(Long id);
    public abstract List<T> buscarTodos();
    public abstract Boolean login(String login, String senha);
    public abstract Boolean existe(Long id, String cpf, String login, String email);
}
