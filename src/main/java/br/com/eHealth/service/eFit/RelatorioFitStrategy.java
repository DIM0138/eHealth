package br.com.eHealth.service.eFit;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eFit.RelatorioFit;
import br.com.eHealth.model.eFit.dto.RelatorioFitDTO;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.service.eHealth.RelatorioStrategy;

@Component
public class RelatorioFitStrategy extends RelatorioStrategy<RelatorioFit, RelatorioFitDTO, Medicao, MedicaoRelatorio> {

    @Override
    protected void validateMandatoryFieldsImp(RelatorioFitDTO relatorioDTO, ArrayList<String> errors) {
        if(relatorioDTO.getPeso() == null || relatorioDTO.getPeso().isEmpty()) {
            errors.add("O peso atual do paciente deve ser informado");
        }

        if(relatorioDTO.getPercentualGordura() == null || relatorioDTO.getPercentualGordura().isEmpty()) {
            errors.add("O percentual de gordura atual do paciente deve ser informado");
        }
    }

    @Override
    protected void validateFieldConstraintsImp(RelatorioFitDTO relatorioDTO, ArrayList<String> errors) {
        if(relatorioDTO.getPercentualGordura() != null && relatorioDTO.getPercentualGordura().isPresent() && relatorioDTO.getPercentualGordura().get() < 0 || relatorioDTO.getPercentualGordura().get() > 80) {
            errors.add("O percentual de gordura deve estar entre 0 e 80.");
        }
    }

    @Override
    protected void validateMedicoesArrayImp(RelatorioFitDTO relatorioDTO, ArrayList<String> errors) {
        for(MedicaoRelatorio medicao : relatorioDTO.getMedicoes().get()) {
            if(medicao.getMedicao().getNome().toUpperCase().equals("PESO") || medicao.getMedicao().getNome().toUpperCase().equals("PERCENTUAL DE GORDURA")) {
                errors.add("As medicoes PESO e PERCENTUAL DE GORDURA devem ser informadas em seu campo específico.");
            }
        }
    }

    @Override
    protected RelatorioFit saveImp(RelatorioFit novoRelatorio) {
        return this.relatorioRepository.save(novoRelatorio);
    }

    @Override
    protected RelatorioFit relatorioFactory() {
        return new RelatorioFit();
    }
    
}
