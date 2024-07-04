package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.Usuario;
import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class UsuarioStrategy<T extends Usuario, DTO extends UsuarioDTO> {
    
    @Autowired
    private UsuarioRepository<T> repository;

    public final ArrayList<String> validateUser(DTO usuarioDTO) {
        ArrayList<String> errors = new ArrayList<String>();

        if (usuarioDTO.getNomeCompleto() == null || usuarioDTO.getNomeCompleto().isEmpty()) {
            errors.add("Um nome deve ser informado.");
        }

        else if (usuarioDTO.getNomeCompleto().get().length() > 50) {
            errors.add("O nome informado deve ter no maximo 50 caracteres.");
        }

        if (usuarioDTO.getLogin() == null || usuarioDTO.getLogin().isEmpty()) {
            errors.add("Um login deve ser informado.");
        }

        else if (repository.existsByLogin(usuarioDTO.getLogin().get())) {
            errors.add("O login informado já foi cadastrado.");
        }

        else if (usuarioDTO.getLogin().get().length() > 20) {
            errors.add("O login informado deve ter no maximo 20 caracteres.");
        }

        if (usuarioDTO.getEmail() == null || usuarioDTO.getEmail().isEmpty()) {
            errors.add("Um email deve ser informado.");
        }

        else if (repository.existsByEmail(usuarioDTO.getEmail().get())) {
            errors.add("O email informado já foi cadastrado.");
        }

        else if (!usuarioDTO.getEmail().get().matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            errors.add("O email informado é inválido.");
        }

        if (usuarioDTO.getSenha() == null || usuarioDTO.getSenha().isEmpty()) {
            errors.add("Uma senha deve ser informada.");
        }

        else if (usuarioDTO.getSenha().get().length() > 20) {
            errors.add("A senha informada deve ter no maximo 20 caracteres.");
        }

        if(usuarioDTO.getCPF() == null || usuarioDTO.getCPF().isEmpty()) {
            errors.add("O CPF deve ser informado.");
        }

        else if (repository.existsByCPF(usuarioDTO.getCPF().get())) {
            errors.add("O CPF informado já foi cadastrado.");
        }

        else if (!usuarioDTO.getCPF().get().matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            errors.add("O CPF deve ser no formato 000.000.000-00.");
        }

        if (!usuarioDTO.getTelefone().get().isEmpty() && !usuarioDTO.getTelefone().get().matches("\\(\\d{2}\\)\\s?\\d{5}-\\d{4}")) {
            errors.add("O telefone deve ser no formato (00) 00000-0000.");
        }

        List<String> generos = List.of("FEMININO", "MASCULINO", "OUTRO");
        if(!usuarioDTO.getGenero().get().isEmpty() && usuarioDTO.getGenero().get() != null && !generos.contains(usuarioDTO.getGenero().get())) {
            errors.add("O genero deve ser informado (FEMININO, MASCULINO ou OUTRO).");
        }

        if(usuarioDTO instanceof ProfissionalDTO) {

            ProfissionalDTO profissionalDTO = (ProfissionalDTO) usuarioDTO;

            if(profissionalDTO.getFormacao().get().length() > 40) {
                errors.add("A formação informada deve ter no maximo 40 caracteres.");
            }

            if(profissionalDTO.getEspecialidade().get().length() > 30) {
                errors.add("A especialidade informada deve ter no maximo 30 caracteres.");
            }
            
            if(profissionalDTO.getEnderecoProfissional().get().length() > 100) {
                errors.add("O endereço informado deve ter no maximo 100 caracteres.");
            }
        }

        return validateSpecifics(errors, usuarioDTO);
    }

    public final T save(DTO usuarioDTO) {

        T novoUsuario = usuarioFactory(usuarioDTO);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        try {
            objectMapper.updateValue(novoUsuario, usuarioDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }

        return saveSpecifics(usuarioDTO, novoUsuario);
    }

    public abstract T usuarioFactory(DTO usuarioDTO);

    public abstract ArrayList<String> validateSpecifics(ArrayList<String> errors, UsuarioDTO usuarioDTO);

    public abstract T saveSpecifics(DTO usuarioDTO, T novoUsuario);
}
