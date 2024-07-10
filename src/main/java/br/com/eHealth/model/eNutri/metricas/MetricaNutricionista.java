package br.com.eHealth.model.eNutri.metricas;

import br.com.eHealth.model.eHealth.metricas.AdesaoData;
import br.com.eHealth.model.eHealth.metricas.Metrica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetricaNutricionista extends Metrica {
    AdesaoData adesaoTag;
}
