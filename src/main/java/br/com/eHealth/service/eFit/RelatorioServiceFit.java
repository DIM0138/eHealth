package br.com.eHealth.service.eFit;

import org.springframework.stereotype.Service;

import br.com.eHealth.model.eFit.RelatorioFit;
import br.com.eHealth.model.eFit.dto.RelatorioFitDTO;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.service.eHealth.RelatorioService;

@Service
public class RelatorioServiceFit extends RelatorioService<RelatorioFit, RelatorioFitDTO, Medicao, MedicaoRelatorio> {
    
}
