package br.com.eHealth.model.eFit;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.eHealth.model.eFit.dto.ExercicioDTO;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
public class Exercicio extends Tratamento {

    @JsonProperty("tipo_exercicio")
    @Column(nullable = false)
    private String tipoExercicio;

    @JsonProperty("grupos_musculares")
    @Column(nullable = false)
    private List<String> gruposMusculares;

    @JsonProperty("instrucoes")
    @Column(nullable = false)
    private String instrucoes;

    @JsonProperty("series")
    @Column(nullable = false)
    private int series;

    @JsonProperty("repeticoes")
    @Column(nullable = false)
    private int repeticoes;

    @JsonProperty("carga")
    private List<Double> carga;

    @JsonProperty("intervalo")
    @Column(nullable = false)
    private int intervalo;

    @JsonProperty("dropset")
    @Column(nullable = false)
    private Boolean dropset;

    @JsonProperty("tempo")
    @Column(nullable = false)
    private int tempo;
    
    @Override
    public TratamentoDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, ExercicioDTO.class);
    }
    
}
