package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eHealth.AtividadeDiaria;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.time.LocalTime;

public class AtividadeDiariaDTO {
    private long id;
    private LocalTime horario;
    private final AtividadeDiaria.Emocao emocao = AtividadeDiaria.Emocao.PENDENTE;
    private Boolean atividadeFeita;

    public AtividadeDiariaDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        return objectMapper.convertValue(this, AtividadeDiariaDTO.class);
    }
}

