package br.com.eHealth.controller.eEndo;

import br.com.eHealth.controller.eHealth.TratamentoController;
import br.com.eHealth.model.eEndo.Prescricao;
import br.com.eHealth.model.eEndo.dto.PrescricaoDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prescricoes")
public class PrescricaoController extends TratamentoController<Prescricao, PrescricaoDTO> {
}
