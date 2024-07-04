package br.com.eHealth.service.eHealth;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.TokenCadastro;
import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.repository.eHealth.TokenCadastroRepository;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

@Service
public class TokenCadastroService {

    @Autowired
    private TokenCadastroRepository tokenRepository;

    @Autowired
    private UsuarioRepository<Profissional> profissionalRepository;

    public TokenCadastroDTO novoToken(TokenCadastroDTO tokenDTO) {
        ArrayList<String> errors = new ArrayList<String>();

        if (tokenDTO.getNomePaciente() == null || tokenDTO.getNomePaciente().isEmpty()) {
            errors.add("O nome do paciente deve ser informado.");
        }

        else if(tokenDTO.getNomePaciente().get().length() < 3 || tokenDTO.getNomePaciente().get().length() > 60) {
            errors.add("O nome do paciente deve ter entre 3 e 60 caracteres.");
        }

        if (tokenDTO.getProfissionalResponsavel() == null || tokenDTO.getProfissionalResponsavel().isEmpty()) {
            errors.add("O profissional responsável deve ser informado.");
        }

        else if(profissionalRepository.findById(tokenDTO.getProfissionalResponsavel().get()).isEmpty()){
            errors.add("O profissional responsável informado não existe.");
        }
        
        if(tokenDTO.getEmail() == null || tokenDTO.getEmail().isEmpty()) {
            errors.add("O email deve ser informado.");
        }

        else {
            String email = tokenDTO.getEmail().get();

            if (!email.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$")) {
                errors.add("O email informado é inválido.");
            }

            else if (tokenRepository.existsByEmail(email)) {
                errors.add("O email informado já foi cadastrado.");
            }
        }

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        TokenCadastro novoToken = new TokenCadastro();
        while(tokenRepository.existsById(novoToken.getToken())) {
            novoToken.newToken();
        }

        novoToken.setNomePaciente(tokenDTO.getNomePaciente().get());
        novoToken.setEmail(tokenDTO.getEmail().get());
        novoToken.setProfissionalResponsavel(profissionalRepository.findById(tokenDTO.getProfissionalResponsavel().get()).get());

        return tokenRepository.save(novoToken).toDTO();
    }

    public TokenCadastro buscarToken(String token) {
        try {
            return tokenRepository.findById(token).get();
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Token de ID " + token + " não encontrado.");
        }
    }

    public Boolean deletarToken(String token) {
        try {
            TokenCadastro tokenCadastrado = this.buscarToken(token);
            tokenRepository.delete(tokenCadastrado);
            return true;
        }
        catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Token de ID " + token + " não encontrado.");
        }
    }

    public TokenCadastro usarToken(String token) {
        TokenCadastro tokenCadastrado = this.buscarToken(token);
        tokenCadastrado.setUsado(true);
        return tokenRepository.save(tokenCadastrado);
    }
}
