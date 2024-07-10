package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.ResumoAtividades;

public abstract class ResumoService {
    public abstract ResumoAtividades gerarResumo(Long idPlano);
}
