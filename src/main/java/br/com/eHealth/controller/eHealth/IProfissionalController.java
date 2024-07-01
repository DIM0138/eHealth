package br.com.eHealth.controller.eHealth;

import java.util.List;

import br.com.eHealth.model.eNutri.dto.PacienteDTO;

public abstract interface IProfissionalController extends IUsuarioController{
    
    public abstract List<PacienteDTO> buscarPacientesPorProfissionalId(Long id);
}
