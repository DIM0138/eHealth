package br.com.eHealth.service.eHealth;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.repository.eHealth.MedicaoRelatorioRepository;
import br.com.eHealth.repository.eHealth.RelatorioRepository;
import jakarta.transaction.Transactional;

@Component
public abstract class RelatorioService<T extends Relatorio, DTO extends RelatorioDTO, M extends Medicao, MR extends MedicaoRelatorio> {
    
    @Autowired
    private RelatorioRepository<T> relatorioRepository;

    @Autowired
    private MedicaoRelatorioRepository<MR> medicaoRelatorioRepository;

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
    public RelatorioDTO atualizar(DTO relatorioDTO, Long id) {
        ArrayList<String> errors = new ArrayList<String>();

        errors = this.relatorioStrategy.validateUpdateRelatorio(relatorioDTO, errors, id);

        if (!errors.isEmpty()) {
            throw new ValidationException(errors);
        }

        return this.relatorioStrategy.update(relatorioDTO, id);
    }

    public T buscarPorId(Long id) {
        Optional<T> relatorio = this.relatorioRepository.findById(id);

        if (relatorio.isEmpty()) {
            throw new ResourceNotFoundException("Relatório de ID " + id + " não encontrado");
        }

        return relatorio.get();
    }

    public ArrayList<RelatorioDTO> buscarPorPacienteId(Long idPaciente) {
        List<T> relatorios = this.relatorioRepository.findByPacienteId(idPaciente);

        ArrayList<RelatorioDTO> relatoriosDTO = new ArrayList<>();
        for (T relatorio : relatorios) {
            relatoriosDTO.add(relatorio.toDTO());
        }

        return relatoriosDTO;
    }

    public Boolean deletar(Long id) {
        T relatorio = this.buscarPorId(id);
        this.relatorioRepository.delete(relatorio);
        return true;
    }

    public Boolean deletarMedicao(Long idRelatorio, Long idMedicao) {
        T relatorio = this.buscarPorId(idRelatorio);
        MR medicao = this.medicaoRelatorioRepository.findById(idMedicao).orElseThrow(() -> new ResourceNotFoundException("Medição de ID " + idMedicao + " não encontrado"));
        
        relatorio.getMedicoes().remove(medicao);
        this.medicaoRelatorioRepository.delete(medicao);
        return true;
    }
}
