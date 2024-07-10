package br.com.eHealth.model.eHealth.metricas;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AdesaoData {
    Map<String, Integer> feito = new HashMap<>();
    Map<String, Integer> naoFeito = new HashMap<>();
}
