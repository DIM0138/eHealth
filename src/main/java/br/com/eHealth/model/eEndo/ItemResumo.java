package br.com.eHealth.model.eEndo;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ItemResumo {
    LocalDate data;
    Map<String, List<LocalTime>> medicamentosHorarios = new HashMap<>();

    public void adicionarMedicamento(String medicamento, LocalTime horario) {
        medicamentosHorarios.putIfAbsent(medicamento, new ArrayList<>());
        medicamentosHorarios.get(medicamento).add(horario);
    }

}
