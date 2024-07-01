package br.com.eHealth.service.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;

public class ProfissionalService<T extends ProfissionalDTO> extends UsuarioService<T> {
    
    protected ProfissionalStrategy<T> strategy;

    public ProfissionalService(ProfissionalStrategy<T> strategy) {
        super(strategy);
    }

    public List<PacienteDTO> buscarPacientesPorProfissionalId(Long id) {
        return this.strategy.buscarPacientesPorProfissionalId(id);
    }
}
