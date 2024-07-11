package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eHealth.AtividadeDiaria;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@ToString
public class AtividadeDiariaDTO {
    private long id;
    private LocalTime horario;
    private final AtividadeDiaria.Emocao emocao = AtividadeDiaria.Emocao.PENDENTE;
    private Boolean atividadeFeita;
    private LocalDate data;
    private TratamentoDTO tratamento;
    public AtividadeDiariaDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.convertValue(this, AtividadeDiariaDTO.class);
    }
}

