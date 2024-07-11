package br.com.eHealth.controller.eNutri;

import br.com.eHealth.controller.eHealth.TratamentoController;
import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enutri/receitas")
public class ReceitaController extends TratamentoController<Receita, ReceitaDTO> {
}
