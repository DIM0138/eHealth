package br.com.eHealth.service.eHealth;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import br.com.eHealth.repository.eHealth.TratamentoRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Component
public abstract class TratamentoService<T extends Tratamento, DTO extends TratamentoDTO> {

    @Autowired
    protected TratamentoRepository tratamentoRepository;

    @Autowired
    protected TratamentoStrategy<T, DTO> tratamentoStrategy;

    @Transactional
    public TratamentoDTO criar(DTO tratamentoDTO) {
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

    public Tratamento buscarPorId(long id) {
        try {
            Tratamento tratamento = this.tratamentoRepository.findById(id).get();
            return tratamento;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Tratamento de ID " + id + " não encontrado.");
        }
    }

    public List<TratamentoDTO> buscarTodos() {
        List<Tratamento> tratamentos = tratamentoRepository.findAll();
        return tratamentos.stream().map(tratamento -> tratamento.toDTO()).collect(Collectors.toList());
    }

    public abstract Tratamento tratamentoFactory();

    @Transactional
    public TratamentoDTO atualizar(Long id, DTO tratamentoDTO) {
        Tratamento tratamento = buscarPorId(id);

        ArrayList<String> errors = tratamentoStrategy.validateUpdateTratamento(tratamentoDTO);

        if (!errors.isEmpty()){
            throw new ValidationException(errors);
        }

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        try {
            objectMapper.updateValue(tratamento, tratamentoDTO);
        } catch (JsonMappingException e){
            throw new RuntimeException(e);
        }

        return tratamentoRepository.save(tratamento).toDTO();
    }

    public void deletar(Long id) {
        if (!tratamentoRepository.existsById(id)){
            throw new ResourceNotFoundException("Tratamento não encontrada para remoção");
        }
        try {
            tratamentoRepository.deleteById(id);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
