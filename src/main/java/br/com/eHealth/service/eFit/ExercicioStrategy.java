package br.com.eHealth.service.eFit;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eFit.Exercicio;
import br.com.eHealth.model.eFit.dto.ExercicioDTO;
import br.com.eHealth.repository.eFit.ExercicioRepository;
import br.com.eHealth.service.eHealth.TratamentoStrategy;

@Component
public class ExercicioStrategy extends TratamentoStrategy<Exercicio, ExercicioDTO>{

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Override
    public void validateMandatoryFieldImp(ExercicioDTO tratamentoDTO, ArrayList<String> errors) {
        if(tratamentoDTO.getTipoExercicio() == null) {
            errors.add("Tipo de exercício deve ser informado.");
        }

        if(tratamentoDTO.getGruposMusculares() == null || tratamentoDTO.getGruposMusculares().isEmpty()) {
            errors.add("Grupos musculares utilizados devem ser informados.");
        }

        if(tratamentoDTO.getInstrucoes() == null) {
            errors.add("Instruções devem ser informadas.");
        }

        if(tratamentoDTO.getTempo() == null) {
            errors.add("Tempo de exercício deve ser informado.");
        }

        if(tratamentoDTO.getSeries() == null) {
            errors.add("Quantidade de séries deve ser informada.");
        }

        if(tratamentoDTO.getRepeticoes() == null) {
            errors.add("Quantidade de repetições deve ser informada.");
        }

        if(tratamentoDTO.getDropset() == null) {
            errors.add("Informe se o exercício é do tipo dropset ou não.");
        }

        if(tratamentoDTO.getTipoExercicio() != null && tratamentoDTO.getTipoExercicio().equals("MUSCULACAO")) {
            if(tratamentoDTO.getCarga() == null || tratamentoDTO.getCarga().isEmpty()) {
                errors.add("Carga utilizada deve ser informada.");
            }
        }
        
    }

    @Override
    public void validateFieldConstraintsImp(ExercicioDTO tratamentoDTO, ArrayList<String> errors) {
        List<String> tiposExercicio = List.of("AEROBICO", "MUSCULACAO","FLEXIBILIDADE","EQUILIBRIO","RESISTENCIA","FUNCIONAL","OUTRO");

        if (tratamentoDTO.getTipoExercicio() != null && !tiposExercicio.contains(tratamentoDTO.getTipoExercicio())) {
            errors.add("Tipo de exercício inválido.");
        }

        List<String> gruposMusculares = List.of("SUPERIORES", "PEITORAL", "COSTAS", "BICEPS", "TRICEPS", "OMBROS", "ANTEBRACO", "INFERIORES", "QUADRICEPS", "PANTURRILHA", "GLUTEOS", "POSTERIORES", "ABDOMEN", "FULL_BODY", "OUTRO");
        for(String grupo : tratamentoDTO.getGruposMusculares()) {
            if(!gruposMusculares.contains(grupo)) {
                errors.add("Grupos muscular '" + grupo + "' inválido. ");
            }
        }

        if(tratamentoDTO.getSeries() != null && tratamentoDTO.getSeries() <= 0) {
            errors.add("Quantidade de séries deve ser maior que zero.");
        }

        if(tratamentoDTO.getRepeticoes() != null && tratamentoDTO.getRepeticoes() <= 0) {
            errors.add("Quantidade de repetições deve ser maior que zero.");
        }

        if(tratamentoDTO.getTempo() != null && tratamentoDTO.getTempo() <= 0) {
            errors.add("Tempo de exercício deve ser maior que zero.");
        }

        if(tratamentoDTO.getIntervalo() != null && tratamentoDTO.getIntervalo() <= 0) {
            errors.add("Intervalo de exercício deve ser maior que zero.");
        }

        if(tratamentoDTO.getCarga() != null && !tratamentoDTO.getCarga().isEmpty()) {
            for(Double carga : tratamentoDTO.getCarga()) {
                if(carga < 0) {
                    errors.add("Cargas devem ser maior que zero.");
                    break;
                }
            }
        }

    }

    @Override
    public Exercicio saveImp(ExercicioDTO tratamentoDTO, Exercicio novoTratamento) {
        return this.exercicioRepository.save(novoTratamento);
    }
    
}
