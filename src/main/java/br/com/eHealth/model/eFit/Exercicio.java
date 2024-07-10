package br.com.eHealth.model.eFit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eHealth.model.eFit.dto.ExercicioDTO;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Exercicio extends Tratamento {

    public enum TipoExercicio {
        AEROBICO,
        MUSCULACAO,
        FLEXIBILIDADE,
        EQUILIBRIO,
        RESISTENCIA,
        FUNCIONAL,
        OUTRO
    }

    public enum GrupoMuscular {
        SUPERIORES,
        PEITORAL,
        COSTAS,
        BICEPS,
        TRICEPS,
        OMBROS,
        ANTEBRACO,
        INFERIORES,
        QUADRICEPS,
        PANTURRILHA,
        GLUTEOS,
        POSTERIORES,
        ABDOMEN,
        FULL_BODY,
        OUTRO
    }

    @JsonProperty("tipo_exercicio")
    @Enumerated(EnumType.STRING)
    private TipoExercicio tipoExercicio;

    @JsonProperty("grupos_musculares")
    @Enumerated(EnumType.STRING)
    private List<GrupoMuscular> gruposMusculares;

    @JsonProperty("instrucoes")
    private String instrucoes;

    @JsonProperty("series")
    private int series;

    @JsonProperty("repeticoes")
    private int repeticoes;

    @JsonProperty("carga")
    private List<Double> carga;

    @JsonProperty("intervalo")
    private int intervalo;

    @JsonProperty("dropset")
    private Boolean dropset;

    @JsonProperty("tempo")
    private int tempo;
    
    @Override
    public TratamentoDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, ExercicioDTO.class);
    }
    
}
