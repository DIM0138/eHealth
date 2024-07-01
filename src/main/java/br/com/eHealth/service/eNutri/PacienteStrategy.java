package br.com.eHealth.service.eNutri;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.service.eHealth.UsuarioStrategy;

@Component
public class PacienteStrategy extends UsuarioStrategy<PacienteDTO> {

    @Autowired
    private PacienteRepository repository;

    @Override
    public PacienteDTO criar(PacienteDTO usuarioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criar'");
    }

    @Override
    public PacienteDTO atualizar(PacienteDTO usuarioDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Boolean deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public PacienteDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<PacienteDTO> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Boolean login(String login, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public Boolean existe(Long id, String cpf, String login, String email) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'existe'");
    }

}
