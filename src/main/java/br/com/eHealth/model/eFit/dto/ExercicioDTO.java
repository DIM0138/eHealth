package br.com.eHealth.model.eFit.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eFit.Exercicio;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ExercicioDTO extends TratamentoDTO {

    @JsonProperty("tipo_exercicio")
    private String tipoExercicio;

    @JsonProperty("grupos_musculares")
    private List<String> gruposMusculares;

    @JsonProperty("instrucoes")
    private String instrucoes;

    @JsonProperty("series")
    private Integer series;

    @JsonProperty("repeticoes")
    private Integer repeticoes;

    @JsonProperty("carga")
    private List<Double> carga;

    @JsonProperty("intervalo")
    private Integer intervalo;

    @JsonProperty("dropset")
    private Boolean dropset;

    @JsonProperty("tempo")
    private Integer tempo;

    public ExercicioDTO(Exercicio exercicio) {
        super(exercicio);
        this.tipoExercicio = exercicio.getTipoExercicio();
        this.gruposMusculares = exercicio.getGruposMusculares();
        this.instrucoes = exercicio.getInstrucoes();
        this.series = exercicio.getSeries();
        this.repeticoes = exercicio.getRepeticoes();
        this.carga = exercicio.getCarga();
        this.intervalo = exercicio.getIntervalo();
        this.dropset = exercicio.getDropset();
        this.tempo = exercicio.getTempo();
    }
}
