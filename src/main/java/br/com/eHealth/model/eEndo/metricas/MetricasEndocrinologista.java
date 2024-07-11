package br.com.eHealth.model.eEndo.metricas;

import br.com.eHealth.model.eHealth.metricas.Metrica;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MetricasEndocrinologista extends Metrica {
    Map<LocalDate, Long> frequenciaPrescricao = new HashMap<>();
}
