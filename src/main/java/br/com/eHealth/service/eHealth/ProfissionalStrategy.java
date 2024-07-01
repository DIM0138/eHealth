package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;

import java.util.List;

public abstract class ProfissionalStrategy<T extends ProfissionalDTO> extends UsuarioStrategy<T> {
    public abstract List<PacienteDTO> buscarPacientesPorProfissionalId(Long id);
}
