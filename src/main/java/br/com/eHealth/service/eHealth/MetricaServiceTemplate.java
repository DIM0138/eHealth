package br.com.eHealth.service.eHealth;

import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.metricas.AdesaoData;
import br.com.eHealth.model.eHealth.metricas.Metrica;
import br.com.eHealth.repository.eHealth.PlanoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public abstract class MetricaServiceTemplate {
    @Autowired
    PacienteService pacienteService;

    @Autowired
    PlanoRepository planoRepository;

    public Metrica getPacienteMetricas(Long idPaciente, LocalDate dataInicio, LocalDate dataFim) {
        List<Plano> planos = planoRepository.getByPaciente(pacienteService.buscarPorId(idPaciente));

        List<RegistroDiario> registrosPaciente = new ArrayList<>();
        for (Plano plano : planos) {
            registrosPaciente.addAll(plano.getRegistrosDiarios());
        }

        List<RegistroDiario> registrosDiarios = new ArrayList<>();

        if (dataInicio != null & dataFim != null) {
            for (RegistroDiario registroDiario : registrosPaciente) {
                LocalDate registroData = registroDiario.getData();
                if ((registroData.isEqual(dataInicio) || registroData.isAfter(dataInicio)) &&
                        (registroData.isEqual(dataFim) || registroData.isBefore(dataFim))) {
                    registrosDiarios.add(registroDiario);
                }
            }
        } else {
            registrosDiarios.addAll(registrosPaciente);
        }

        Metrica metricas = criarMetrica();

        metricas.setAdesaoEmocao(adesaoEmocao(registrosDiarios));
        metricas.setQuantidadeQualidadeSono(quantidadeSono(registrosDiarios));
        metricas.setQuantidadeEmocao(quantidadeEmocao(registrosDiarios));
        metricas.setSintomas(sintomas(registrosDiarios));

        adicionarMetricasEspecificas(metricas, registrosDiarios);

        return metricas;
    }

    public abstract Metrica criarMetrica();

    public abstract void adicionarMetricasEspecificas(Metrica metricas, List<RegistroDiario> registrosDiarios);
    public abstract AdesaoData adesaoEmocao(List<RegistroDiario> registrosDiarios);
    public abstract Map<String, Integer> quantidadeSono(List<RegistroDiario> registrosDiarios);

    public abstract Map<String, Integer> quantidadeEmocao(List<RegistroDiario> registrosDiarios);

    public abstract List<String> sintomas(List<RegistroDiario> registrosDiarios);
}

