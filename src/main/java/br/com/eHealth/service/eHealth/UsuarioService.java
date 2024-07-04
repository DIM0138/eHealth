package br.com.eHealth.service.eHealth;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.UnauthorizedAccessException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.Usuario;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.repository.eHealth.UsuarioRepository;
import jakarta.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class UsuarioService<T extends Usuario, DTO extends UsuarioDTO> {

    @Autowired
    protected UsuarioStrategy<T, DTO> usuarioStrategy;

    @Autowired
    protected UsuarioRepository<T> usuarioRepository;

    @Autowired
    protected UsuarioRepository<Profissional> profissionalRepository;
    
    @Transactional
    public UsuarioDTO criar(DTO usuarioDTO) {
        ArrayList<String> errors = this.usuarioStrategy.validateCreateUser(usuarioDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        T novoUsuario = this.usuarioStrategy.save(usuarioDTO);

        return novoUsuario.toDTO();
    }

    @Transactional
    public UsuarioDTO atualizar(DTO usuarioDTO, Long id) {

        T usuario = this.buscarPorId(id);

        ArrayList<String> errors = this.usuarioStrategy.validateUpdateUser(usuarioDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            objectMapper.updateValue(usuario, usuarioDTO);
        }

        catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }

        return this.usuarioRepository.save(usuario).toDTO();
    }

    public Boolean deletar(Long id) {

        Usuario usuario = this.buscarPorId(id);

        this.usuarioRepository.deleteById(usuario.getId());
        
        return true;
    }

    public T buscarPorId(Long id) {

        try {
            T usuario = this.usuarioRepository.findById(id).get();
            return usuario;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Usuário de ID " + id + " não encontrado.");
        }

    }

    public List<UsuarioDTO> buscarTodos() {
        List<T> usuarios = this.usuarioRepository.findAll();

        List<UsuarioDTO> usuariosDTO = usuarios.stream().map(u -> u.toDTO()).toList();

        return usuariosDTO;
    }

    public Boolean login(String login, String senha) {
        Usuario usuario;
        try {
            usuario = this.usuarioRepository.findByLogin(login);
        }
        catch (NoSuchElementException e) {
            throw new UnauthorizedAccessException("Login ou senha inválidos.");
        }

        if (!usuario.getSenha().equals(senha)) {
            throw new UnauthorizedAccessException("Login ou senha inválidos.");
        }

        return true;
    }

    public Boolean existe(Long id, String cpf, String login, String email) {
        return null;
    }
}
