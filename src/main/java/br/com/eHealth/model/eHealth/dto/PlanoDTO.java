package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class PlanoDTO {
    
    private long id;

    private PacienteDTO paciente;

    private long profissionalResponsavel;

    private LocalDate dataInicio;

    private LocalDate dataFim;

    private Boolean ativo = false;

    private List<RegistroDiarioDTO> registrosDiarios;   
}
