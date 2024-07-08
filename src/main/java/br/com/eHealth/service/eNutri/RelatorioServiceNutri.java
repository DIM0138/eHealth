package br.com.eHealth.service.eNutri;

import org.springframework.stereotype.Service;

import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.service.eHealth.RelatorioService;

@Service
public class RelatorioServiceNutri extends RelatorioService<Relatorio, RelatorioDTO, Medicao, MedicaoRelatorio> {
    
}
