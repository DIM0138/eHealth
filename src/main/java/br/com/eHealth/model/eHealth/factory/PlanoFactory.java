package br.com.eHealth.model.eHealth.factory;

import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;

public abstract interface PlanoFactory {
    
    public abstract Plano criarPlano(PlanoDTO planoDTO);
}
