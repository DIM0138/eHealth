package br.com.eHealth.service.eHealth;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.repository.eHealth.RelatorioRepository;
import jakarta.transaction.Transactional;

@Component
public abstract class RelatorioService<T extends Relatorio, DTO extends RelatorioDTO, M extends Medicao, MR extends MedicaoRelatorio> {
    
    @Autowired
    private RelatorioRepository<T> relatorioRepository;

    @Autowired
    private RelatorioStrategy<T, DTO, M, MR> relatorioStrategy;

    @Transactional
    public RelatorioDTO criar(DTO relatorioDTO) {
        ArrayList<String> errors = this.relatorioStrategy.validateCreateRelatorio(relatorioDTO);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        T novoRelatorio = this.relatorioStrategy.save(relatorioDTO);

        return novoRelatorio.toDTO();
    }

    @Transactional
    public DTO atualizar(DTO relatorioDTO, Long id) {

        return null;
    }

    public RelatorioDTO buscarPorId(Long id) {
        Optional<T> relatorio = this.relatorioRepository.findById(id);

        if (relatorio.isEmpty()) {
            throw new ResourceNotFoundException("Relatório de ID " + id + " não encontrado");
        }

        return relatorio.get().toDTO();
    }

    public ArrayList<DTO> buscarPorPaciente(Long idPaciente) {
        return null;
    }

    public Boolean deletar(Long id) {
        return null;
    }
}
