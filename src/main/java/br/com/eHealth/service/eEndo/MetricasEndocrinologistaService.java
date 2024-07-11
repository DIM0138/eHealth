package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.metricas.MetricasEndocrinologista;
import br.com.eHealth.model.eHealth.AtividadeDiaria;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.metricas.AdesaoData;
import br.com.eHealth.model.eHealth.metricas.Metrica;
import br.com.eHealth.model.eNutri.metricas.MetricaNutricionista;
import br.com.eHealth.service.eHealth.MetricaServiceTemplate;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Primary
public class MetricasEndocrinologistaService extends MetricaServiceTemplate {
    @Override
    public Metrica criarMetrica() {
        return new MetricasEndocrinologista();
    }

    @Override
    public void adicionarMetricasEspecificas(Metrica metricas, List<RegistroDiario> registrosDiarios) {
        MetricasEndocrinologista metricasEndocrinologista = (MetricasEndocrinologista) metricas;
        metricasEndocrinologista.setFrequenciaPrescricao(frequenciaPrescricao(registrosDiarios));
    }

    public Map<LocalDate, Long> frequenciaPrescricao(List<RegistroDiario> registrosDiarios){
        Map<LocalDate, Long> frequenciaAtividades = new HashMap<>();

        for (RegistroDiario registro : registrosDiarios) {
            long atividadesCumpridas = registro.getAtividasDiarias().stream()
                    .filter(atividade -> atividade.getAtividadeFeita() != null && atividade.getAtividadeFeita())
                    .count();

            frequenciaAtividades.put(registro.getData(), atividadesCumpridas);
        }
        return frequenciaAtividades;
    }

    @Override
    public AdesaoData adesaoEmocao(List<RegistroDiario> registrosDiarios) {
        List<AtividadeDiaria> medicacoes = new ArrayList<AtividadeDiaria>();

        for (RegistroDiario registroDiario : registrosDiarios){
            medicacoes.addAll(registroDiario.getAtividasDiarias());
        }

        AdesaoData adesaoEmocao = new AdesaoData();

        for (AtividadeDiaria medicacao : medicacoes) {
            Boolean atividadeFeita = medicacao.getAtividadeFeita();
            if (atividadeFeita != null) {
                String emocao = medicacao.getEmocao().toString();
                if (atividadeFeita) {
                    adesaoEmocao.getFeito().put(emocao, adesaoEmocao.getFeito().getOrDefault(emocao, 0)+1);
                }
                else {
                    adesaoEmocao.getNaoFeito().put(emocao, adesaoEmocao.getNaoFeito().getOrDefault(emocao, 0)+1);
                }
            }
        }

        return adesaoEmocao;
    }

    @Override
    public Map<String, Integer> quantidadeSono(List<RegistroDiario> registrosDiarios) {
        Map<String, Integer> quantidadeSono = new HashMap<>();

        for (RegistroDiario registroDiario : registrosDiarios){
            String tipoSono = registroDiario.getQualidadeSono().toString();
            if (!Objects.equals(tipoSono, "PENDENTE")){
                quantidadeSono.put(tipoSono, quantidadeSono.getOrDefault(tipoSono, 0)+1);
            }
        }
        return quantidadeSono;
    }

    @Override
    public Map<String, Integer> quantidadeEmocao(List<RegistroDiario> registrosDiarios) {
        List<AtividadeDiaria> atividades = new ArrayList<AtividadeDiaria>();

        for (RegistroDiario registroDiario : registrosDiarios){
            atividades.addAll(registroDiario.getAtividasDiarias());
        }

        Map<String, Integer> quantidadeEmocao = new HashMap<>();

        for (AtividadeDiaria atividade : atividades){
            String tipoEmocao = atividade.getEmocao().toString();
            if (!Objects.equals(tipoEmocao, "PENDENTE")){
                quantidadeEmocao.put(tipoEmocao, quantidadeEmocao.getOrDefault(tipoEmocao, 0)+1);
            }
        }

        return quantidadeEmocao;
    }

    @Override
    public List<String> sintomas(List<RegistroDiario> registrosDiarios) {
        List<String> sintomas = new ArrayList<>();

        for (RegistroDiario registroDiario : registrosDiarios){
            sintomas.addAll(registroDiario.getSintomas());
        }

        return sintomas;
    }
}
