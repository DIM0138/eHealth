package br.com.eHealth.service.eHealth;

import org.springframework.stereotype.Component;

import java.util.List;

import br.com.eHealth.model.eNutri.dto.PacienteDTO;

public class ProfissionalService extends UsuarioService {
    
    protected ProfissionalStrategy strategy;

    public ProfissionalService(ProfissionalStrategy strategy) {
        super(strategy);
    }

    public List<PacienteDTO> buscarPacientesPorProfissional(Long id) {
        return this.strategy.buscarPacientesPorProfissional(id);
    }
}
