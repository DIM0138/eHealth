package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eNutri.dto.PacienteDTO;

import java.util.List;

public abstract class ProfissionalStrategy extends UsuarioStrategy {
    public abstract List<PacienteDTO> buscarPacientesPorProfissional(Long id);
}
