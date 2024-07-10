package br.com.eHealth.service.eNutri;

import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import br.com.eHealth.model.eNutri.Ingrediente;
import br.com.eHealth.model.eNutri.IngredienteReceita;
import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import br.com.eHealth.repository.eNutri.IngredienteRepository;
import br.com.eHealth.service.eHealth.TratamentoService;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ReceitaService extends TratamentoService<Receita, ReceitaDTO> {

    @Autowired
    protected IngredienteRepository ingredienteRepository;

    @Override
    public Tratamento tratamentoFactory() {
        return new Receita();
    }

    @Override
    public TratamentoDTO criar(ReceitaDTO tratamentoDTO) {
        for (IngredienteReceita ingredienteReceita : tratamentoDTO.getIngredientes()){
            Ingrediente ingredienteExistente = ingredienteRepository.findOneByNomeIgnoreCaseAndMedida(
                    ingredienteReceita.getIngrediente().getNome(), ingredienteReceita.getIngrediente().getMedida()
            );
            if (ingredienteExistente != null) {
                ingredienteReceita.setIngrediente(ingredienteExistente);
            } else {
                Ingrediente ingredienteNovo = ingredienteRepository.save(ingredienteReceita.getIngrediente());
                ingredienteReceita.setIngrediente(ingredienteNovo);
            }
        }

        ArrayList<String> errors = tratamentoStrategy.validateCreateTratamento(tratamentoDTO);
        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }

        Tratamento novoTratamento = tratamentoFactory();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            objectMapper.updateValue(novoTratamento, tratamentoDTO);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        }
        return tratamentoRepository.save(novoTratamento).toDTO();
    }
}
