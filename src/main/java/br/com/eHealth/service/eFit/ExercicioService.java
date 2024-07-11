package br.com.eHealth.service.eFit;

import br.com.eHealth.model.eFit.Exercicio;
import br.com.eHealth.model.eFit.dto.ExercicioDTO;
import br.com.eHealth.service.eHealth.TratamentoService;

public class ExercicioService extends TratamentoService<Exercicio, ExercicioDTO> {

    @Override
    public Exercicio tratamentoFactory() {
        return new Exercicio();
    }
    
}
