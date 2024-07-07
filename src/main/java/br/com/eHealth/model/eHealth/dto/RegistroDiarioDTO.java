package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eHealth.RegistroDiario;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class RegistroDiarioDTO {
    private long id;
    private long Plano;
    private LocalDate data;
    private List<AtividadeDiariaDTO> atividadesDiarias;
    private List<String> sintomas;
    private RegistroDiario.QualidadeSono qualidadeSono;
    private List<Long> quantidadeAgua;

}
