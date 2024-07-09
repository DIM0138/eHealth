package br.com.eHealth.controller.eNutri;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.RelatorioController;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;

@RestController
@RequestMapping("/enutri/relatorios")
public class RelatorioControllerNutri extends RelatorioController<Relatorio, RelatorioDTO, Medicao, MedicaoRelatorio> {
    
}
