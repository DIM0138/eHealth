package br.com.eHealth.service.eNutri;


import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import br.com.eHealth.repository.eNutri.IngredienteRepository;
import br.com.eHealth.service.eHealth.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceitaService extends TratamentoService<Receita, ReceitaDTO> {

    @Autowired
    protected IngredienteRepository ingredienteRepository;

    @Override
    public Receita tratamentoFactory() {
        return new Receita();
    }
}
