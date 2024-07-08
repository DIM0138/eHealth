package br.com.eHealth.service.eNutri;

import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import br.com.eHealth.service.eHealth.TratamentoService;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService extends TratamentoService<Receita, ReceitaDTO> {
    @Override
    public Tratamento tratamentoFactory() {
        return new Receita();
    }
}
