package br.com.eHealth.controller.eEndo;


import br.com.eHealth.controller.eHealth.RelatorioController;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endo/relatorios")
public class RelatorioEndoController extends RelatorioController<Relatorio, RelatorioDTO, Medicao, MedicaoRelatorio> {
}
