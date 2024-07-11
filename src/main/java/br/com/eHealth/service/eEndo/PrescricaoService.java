package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.Prescricao;
import br.com.eHealth.model.eEndo.dto.PrescricaoDTO;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.service.eHealth.TratamentoService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class PrescricaoService extends TratamentoService<Prescricao, PrescricaoDTO> {

    @Override
    public Tratamento tratamentoFactory() {
        return new Prescricao();
    }
}
