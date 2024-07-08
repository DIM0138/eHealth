package br.com.eHealth.service.eNutri;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.service.eHealth.RelatorioStrategy;

@Component
public class RelatorioStrategyNutri extends RelatorioStrategy<Relatorio, RelatorioDTO, Medicao, MedicaoRelatorio> {

    @Override
    protected void validateMandatoryFieldsImp(RelatorioDTO relatorioDTO, ArrayList<String> errors) {

    }

    @Override
    protected void validateFieldConstraintsImp(RelatorioDTO relatorioDTO, ArrayList<String> errors) {
    }

    @Override
    protected Relatorio relatorioFactory() {
        return new Relatorio();
    }
    
}
