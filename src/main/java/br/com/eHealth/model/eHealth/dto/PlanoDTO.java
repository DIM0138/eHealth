package br.com.eHealth.model.eHealth.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PlanoDTO {
    
    private long id;

    private long paciente;

    private long profissionalResponsavel;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Boolean ativo = false;

    private List<RegistroDiarioDTO> registrosDiarios;   
}
