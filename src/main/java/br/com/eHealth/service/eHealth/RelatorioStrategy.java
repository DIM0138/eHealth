package br.com.eHealth.service.eHealth;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.repository.eHealth.MedicaoRepository;
import br.com.eHealth.repository.eHealth.RelatorioRepository;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

@Component
public abstract class RelatorioStrategy<T extends Relatorio, DTO extends RelatorioDTO, M extends Medicao, MR extends MedicaoRelatorio> {
    
    @Autowired
    protected RelatorioRepository<T> relatorioRepository;

    @Autowired
    protected UsuarioRepository<Paciente> pacienteRepository;

    @Autowired 
    protected UsuarioRepository<Profissional> profissionalRepository;

    @Autowired
    protected MedicaoRepository<Medicao> medicaoRepository;

    public final ArrayList<String> validateCreateRelatorio(DTO relatorioDTO) {

        ArrayList<String> errors = new ArrayList<String>();

        if(relatorioDTO.getPaciente() != null && relatorioDTO.getDataConsulta() != null) {
            if(this.relatorioRepository.existsByDataConsultaAndPacienteId(relatorioDTO.getDataConsulta().get(), relatorioDTO.getPaciente().get())) {
                errors.add("O paciente informado já possui um relatório para esta data.");
                return errors;
            }
        }

        validateMandatoryFields(relatorioDTO, errors);

        if(!errors.isEmpty()) {
            return errors;
        }

        validateFieldConstraints(relatorioDTO, errors);

        return errors;
    }

    public final ArrayList<String> validateUpdateRelatorio(DTO relatorioDTO, ArrayList<String> errors, Long id) {

        T relatorio = this.relatorioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Relatório de ID " + id + " não encontrado."));

        if(relatorioDTO.getDataConsulta() != null && this.relatorioRepository.existsByDataConsultaAndPacienteId(relatorioDTO.getDataConsulta().get(), relatorioDTO.getPaciente().get()) && !relatorio.getDataConsulta().equals(relatorioDTO.getDataConsulta().get())) {
            errors.add("O paciente informado já possui um relatório para esta data.");
            return errors;
        }

        validateMedicoesArray(relatorioDTO, errors);

        return errors;
    }

    private final void validateMandatoryFields(DTO relatorioDTO, ArrayList<String> errors) {

        if(relatorioDTO.getPaciente() == null || relatorioDTO.getPaciente().isEmpty()) {
            errors.add("Um paciente deve ser informado");
        }

        if(relatorioDTO.getProfissionalResponsavel() == null || relatorioDTO.getProfissionalResponsavel().isEmpty()) {
            errors.add("Um profissional responsável deve ser informado");
        }

        if(relatorioDTO.getDataConsulta() == null || relatorioDTO.getDataConsulta().isEmpty()) {
            errors.add("Uma data de consulta deve ser informada");
        }

        validateMedicoesArray(relatorioDTO, errors);
    
        validateMandatoryFieldsImp(relatorioDTO, errors);
    }

    private final void validateFieldConstraints(DTO relatorioDTO, ArrayList<String> errors) {

        Optional<Paciente> paciente = this.pacienteRepository.findById(relatorioDTO.getPaciente().get());

        if(paciente.isEmpty()) {
            errors.add("O paciente informado não existe.");
        }

        Optional<Profissional> profissional = this.profissionalRepository.findById(relatorioDTO.getProfissionalResponsavel().get());

        if(profissional.isEmpty()) {
            errors.add("O profissional responsável informado não existe.");
        }

        validateFieldConstraintsImp(relatorioDTO, errors);
    }

    private final void validateMedicoesArray(DTO relatorioDTO, ArrayList<String> errors) {

        if(relatorioDTO.getMedicoes() == null || relatorioDTO.getMedicoes().isEmpty() || relatorioDTO.getMedicoes().get().isEmpty()) {
            errors.add("Ao menos uma medição deve ser informada.");
        }

        else {
            for(MedicaoRelatorio medicaoRelatorio : relatorioDTO.getMedicoes().get()) {
                if(medicaoRelatorio == null || medicaoRelatorio.getMedicao() == null) {
                    errors.add("Medição inválida informada.");
                }
                else if(medicaoRelatorio.getValor() == null){
                    errors.add("O valor de " + medicaoRelatorio.getMedicao().getNome() + " deve ser informado.");
                }
            }
            
            validateMedicoesArrayImp(relatorioDTO, errors);
        }
    }

    public final T save(DTO relatorioDTO) {

        T novoRelatorio = this.relatorioFactory();

        Paciente paciente = this.pacienteRepository.findById(relatorioDTO.getPaciente().get()).get();
        Profissional profissional = this.profissionalRepository.findById(relatorioDTO.getProfissionalResponsavel().get()).get();

        novoRelatorio.setPaciente(paciente);
        novoRelatorio.setProfissionalResponsavel(profissional);
        novoRelatorio.setDataConsulta(relatorioDTO.getDataConsulta().get());
        novoRelatorio.setMedicoes(relatorioDTO.getMedicoes().get());

        for(MedicaoRelatorio medicaoRelatorio : relatorioDTO.getMedicoes().get()) {
            Optional<Medicao> medicaoExistente = this.medicaoRepository.findOneByNomeIgnoreCaseAndUnidadeIgnoreCase(medicaoRelatorio.getMedicao().getNome(), medicaoRelatorio.getMedicao().getUnidade());
            if(medicaoExistente.isPresent()) {
                medicaoRelatorio.setMedicao(medicaoExistente.get());
            }
            else {
                Medicao novaMedicao = this.medicaoRepository.save(medicaoRelatorio.getMedicao());
                medicaoRelatorio.setMedicao(novaMedicao);
            }
        }

        novoRelatorio.setMedicoes(relatorioDTO.getMedicoes().get());

        T relatorioSalvo = this.saveImp(novoRelatorio);

        return relatorioSalvo; 
    }

    public final RelatorioDTO update(DTO relatorioDTO, Long id) {
        T relatorio = this.relatorioRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Relatório de ID " + id + " não encontrado."));

        for(MedicaoRelatorio medicaoRelatorio : relatorioDTO.getMedicoes().get()) {
            Optional<Medicao> medicaoExistente = this.medicaoRepository.findOneByNomeIgnoreCaseAndUnidadeIgnoreCase(medicaoRelatorio.getMedicao().getNome(), medicaoRelatorio.getMedicao().getUnidade());
            if(medicaoExistente.isPresent()) {
                medicaoRelatorio.setMedicao(medicaoExistente.get());
            }
            else {
                Medicao novaMedicao = this.medicaoRepository.save(medicaoRelatorio.getMedicao());
                medicaoRelatorio.setMedicao(novaMedicao);
                relatorio.getMedicoes().add(medicaoRelatorio);
            }
        }

        for(MedicaoRelatorio medicaoRelatorio : relatorioDTO.getMedicoes().get()) {
            for(MedicaoRelatorio medicaoRelatorioExistente : relatorio.getMedicoes()) {
                if(medicaoRelatorio.getMedicao().equals(medicaoRelatorioExistente.getMedicao())) {
                    medicaoRelatorioExistente.setValor(medicaoRelatorio.getValor());
                }
            }
        }

        if(relatorioDTO.getDataConsulta().isPresent()) {
            relatorio.setDataConsulta(relatorioDTO.getDataConsulta().get());
        }

        return this.saveImp(relatorio).toDTO();
    }

    protected abstract void validateMandatoryFieldsImp(DTO relatorioDTO, ArrayList<String> errors);
    protected abstract void validateFieldConstraintsImp(DTO relatorioDTO, ArrayList<String> errors);
    protected abstract void validateMedicoesArrayImp(DTO relatorioDTO, ArrayList<String> errors);
    protected abstract T saveImp(T novoRelatorio);


    protected abstract T relatorioFactory();
}
