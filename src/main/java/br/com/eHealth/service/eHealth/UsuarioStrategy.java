package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.TokenCadastro;
import br.com.eHealth.model.eHealth.Usuario;
import br.com.eHealth.model.eHealth.dto.PacienteDTO;
import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.repository.eHealth.TokenCadastroRepository;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public abstract class UsuarioStrategy<T extends Usuario, DTO extends UsuarioDTO> {
    
    @Autowired
    private UsuarioRepository<T> repository;

    @Autowired
    private UsuarioRepository<Profissional> profissionalRepository;

    @Autowired
    private TokenCadastroRepository tokenRepository;

    @Autowired
    private TokenCadastroService tokenService;

    private final void validateMandatoryFields(DTO usuarioDTO, ArrayList<String> errors) {
        
        if (usuarioDTO.getNomeCompleto() == null || usuarioDTO.getNomeCompleto().isEmpty()) {
            errors.add("Um nome deve ser informado.");
        }

        if (usuarioDTO.getLogin() == null || usuarioDTO.getLogin().isEmpty()) {
            errors.add("Um login deve ser informado.");
        }

        if (usuarioDTO.getEmail() == null || usuarioDTO.getEmail().isEmpty()) {
            errors.add("Um email deve ser informado.");
        }

        if (usuarioDTO.getSenha() == null || usuarioDTO.getSenha().isEmpty()) {
            errors.add("Uma senha deve ser informada.");
        }

        if(usuarioDTO.getCPF() == null || usuarioDTO.getCPF().isEmpty()) {
            errors.add("Um CPF deve ser informado.");
        }

        this.validateMandatoryFieldsImp(usuarioDTO, errors);
    }

    private final void validateFieldConstraints (DTO usuarioDTO, ArrayList<String> errors) {

    if (usuarioDTO.getNomeCompleto() != null && usuarioDTO.getNomeCompleto().isPresent() && usuarioDTO.getNomeCompleto().get().length() > 50) {
        errors.add("O nome informado deve ter no máximo 50 caracteres.");
    }

    if (usuarioDTO.getLogin() != null && usuarioDTO.getLogin().isPresent()) {
        String login = usuarioDTO.getLogin().get();
        if (login.length() > 20) {
            errors.add("O login informado deve ter no máximo 20 caracteres.");
        } else if (repository.existsByLogin(login)) {
            errors.add("O login informado já foi cadastrado.");
        }
    }

    if (usuarioDTO.getEmail() != null && usuarioDTO.getEmail().isPresent()) {
        String email = usuarioDTO.getEmail().get();
        if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
            errors.add("O email informado é inválido.");
        } else if (repository.existsByEmail(email)) {
            errors.add("O email informado já foi cadastrado.");
        }
    }

    if (usuarioDTO.getSenha() != null && usuarioDTO.getSenha().isPresent() && usuarioDTO.getSenha().get().length() > 20) {
        errors.add("A senha informada deve ter no máximo 20 caracteres.");
    }

    if (usuarioDTO.getCPF() != null && usuarioDTO.getCPF().isPresent()) {
        String cpf = usuarioDTO.getCPF().get();
        if (!cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}")) {
            errors.add("O CPF deve ser no formato 000.000.000-00.");
        } else if (repository.existsByCPF(cpf)) {
            errors.add("O CPF informado já foi cadastrado.");
        }
    }

    if (usuarioDTO.getTelefone() != null && usuarioDTO.getTelefone().isPresent()) {
        String telefone = usuarioDTO.getTelefone().get();
        if (!telefone.isEmpty() && !telefone.matches("\\(\\d{2}\\)\\s?\\d{5}-\\d{4}")) {
            errors.add("O telefone deve ser no formato (00) 00000-0000.");
        }
    }

    if (usuarioDTO.getGenero() != null && usuarioDTO.getGenero().isPresent()) {
        List<String> generos = List.of("FEMININO", "MASCULINO", "OUTRO");
        String genero = usuarioDTO.getGenero().get();
        if (!genero.isEmpty() && !generos.contains(genero)) {
            errors.add("O gênero deve ser informado (FEMININO, MASCULINO ou OUTRO).");
        }
    }

    if (usuarioDTO instanceof ProfissionalDTO) {
        ProfissionalDTO profissionalDTO = (ProfissionalDTO) usuarioDTO;

        if (profissionalDTO.getFormacao() != null && profissionalDTO.getFormacao().isPresent() && profissionalDTO.getFormacao().get().length() > 40) {
            errors.add("A formação informada deve ter no máximo 40 caracteres.");
        }

        if (profissionalDTO.getEspecialidade() != null && profissionalDTO.getEspecialidade().isPresent() && profissionalDTO.getEspecialidade().get().length() > 30) {
            errors.add("A especialidade informada deve ter no máximo 30 caracteres.");
        }

        if (profissionalDTO.getEnderecoProfissional() != null && profissionalDTO.getEnderecoProfissional().isPresent() && profissionalDTO.getEnderecoProfissional().get().length() > 100) {
            errors.add("O endereço informado deve ter no máximo 100 caracteres.");
        }
    }

        this.validateFieldConstraintsImp(usuarioDTO, errors);
    }

    public final ArrayList<String> validateCreateUser(DTO usuarioDTO) {
        ArrayList<String> errors = new ArrayList<String>();

        validateMandatoryFields(usuarioDTO, errors);

        if(errors.size() > 0) {
            return errors;
        }

        validateFieldConstraints(usuarioDTO, errors);

        if (usuarioDTO instanceof PacienteDTO) {

            PacienteDTO pacienteDTO = (PacienteDTO) usuarioDTO;

            if (pacienteDTO.getProfissionalResponsavel() == null || pacienteDTO.getProfissionalResponsavel().isEmpty()) {
                errors.add("Um profissional responsável deve ser informado.");
            }
    
            else if(profissionalRepository.findById(pacienteDTO.getProfissionalResponsavel().get()).isEmpty()){
                errors.add("O profissional responsável informado não existe.");
            }

            if (pacienteDTO.getToken() == null || pacienteDTO.getToken().isEmpty()) {
                errors.add("Um token de cadastro deve ser informado.");
            }
            else {
                Optional<TokenCadastro> token = tokenRepository.findById(pacienteDTO.getToken().get());

                if (token.isEmpty()) {
                    errors.add("O token de cadastro informado não existe.");
                }
                else if(token.get().isUsado()) {
                    errors.add("O token de cadastro informado já foi usado.");
                }
                else if(!token.get().getEmail().equals(pacienteDTO.getEmail().get())) {
                    errors.add("O token de cadastro informado não corresponde ao email informado.");
                }
            }
        }

        return errors;
    }

    public final ArrayList<String> validateUpdateUser(DTO usuarioDTO) {

        ArrayList<String> errors = new ArrayList<String>();

        validateFieldConstraints(usuarioDTO, errors);

        return errors;
    }
    
    public final T save(DTO usuarioDTO) {

        T novoUsuario = usuarioFactory();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            objectMapper.updateValue(novoUsuario, usuarioDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }

        if (novoUsuario instanceof Paciente) {
            PacienteDTO pacienteDTO = (PacienteDTO) usuarioDTO;
            Paciente novoPaciente = (Paciente) novoUsuario;

            Long idProfissional = pacienteDTO.getProfissionalResponsavel().get();
            novoPaciente.setProfissionalResponsavel(profissionalRepository.findById(idProfissional).get());

            String token = pacienteDTO.getToken().get();
            tokenService.usarToken(token);
        }

        return this.repository.save(novoUsuario);
    }

    protected abstract T usuarioFactory();

    protected abstract void validateMandatoryFieldsImp(DTO usuarioDTO, ArrayList<String> errors);

    protected abstract void validateFieldConstraintsImp(DTO usuarioDTO, ArrayList<String> errors);
}
