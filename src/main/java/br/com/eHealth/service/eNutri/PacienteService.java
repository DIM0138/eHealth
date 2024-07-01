package br.com.eHealth.service.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.service.eHealth.UsuarioService;

@Service
public class PacienteService extends UsuarioService<PacienteDTO> {
    
    public PacienteService(@Autowired PacienteStrategy pacienteStrategy) {
        super(pacienteStrategy);
    }

    public TokenCadastroDTO novoToken(String nomePaciente) {
        return null;
    }

    public TokenCadastroDTO buscarPorToken(String token) {
        return null;
    }
}
