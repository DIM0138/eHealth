package br.com.eHealth.controller.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;

public abstract interface IProfissionalController<S extends ProfissionalDTO> extends IUsuarioController<S> {
    
    public abstract List<PacienteDTO> buscarPacientesPorProfissionalId(Long id);
}
