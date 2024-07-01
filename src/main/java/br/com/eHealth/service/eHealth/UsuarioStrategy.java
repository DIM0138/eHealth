package br.com.eHealth.service.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

public abstract class UsuarioStrategy {

    public abstract UsuarioDTO criar(UsuarioDTO usuarioDTO);
    public abstract UsuarioDTO atualizar(UsuarioDTO usuarioDTO, Long id);
    public abstract Boolean deletar(Long id);
    public abstract UsuarioDTO buscarPorId(Long id);
    public abstract List<UsuarioDTO> buscarTodos();
    public abstract Boolean login(String login, String senha);
    public abstract Boolean existe(Long id, String cpf, String login, String email);
}
