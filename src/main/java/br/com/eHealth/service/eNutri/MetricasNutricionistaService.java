package br.com.eHealth.service.eNutri;

import br.com.eHealth.model.eHealth.AtividadeDiaria;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.metricas.AdesaoData;
import br.com.eHealth.model.eHealth.metricas.Metrica;
import br.com.eHealth.model.eNutri.Receita;
import br.com.eHealth.model.eNutri.metricas.MetricaNutricionista;
import br.com.eHealth.service.eHealth.MetricaServiceTemplate;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MetricasNutricionistaService extends MetricaServiceTemplate {

    @Override
    public Metrica criarMetrica() {
        return new MetricaNutricionista();
    }

    @Override
    public void adicionarMetricasEspecificas(Metrica metricas, List<RegistroDiario> registrosDiarios) {
        MetricaNutricionista metricaNutricionista = (MetricaNutricionista) metricas;
        metricaNutricionista.setAdesaoTag(adesaoTag(registrosDiarios));
    }

    public AdesaoData adesaoTag(List<RegistroDiario> registroDiarios){
        List<AtividadeDiaria> refeicoes = new ArrayList<AtividadeDiaria>();

        for (RegistroDiario registroDiario : registroDiarios){
            refeicoes.addAll(registroDiario.getAtividasDiarias());
        }

        AdesaoData adesaoTag = new AdesaoData();

        for (AtividadeDiaria refeicao : refeicoes) {
            Boolean refeicaoFeita = refeicao.getAtividadeFeita();
            if (refeicaoFeita != null) {
                Receita receita = (Receita) refeicao.getTratamento();
                String tipoRefeicao = receita.getTipoRefeicao().toString();
                if (refeicaoFeita){
                    adesaoTag.getFeito().put(tipoRefeicao, adesaoTag.getFeito().getOrDefault(tipoRefeicao, 0)+1);
                } else {
                    adesaoTag.getNaoFeito().put(tipoRefeicao, adesaoTag.getNaoFeito().getOrDefault(tipoRefeicao, 0)+1);
                }
            }
        }

        return adesaoTag;
    }

    @Override
    public AdesaoData adesaoEmocao(List<RegistroDiario> registroDiarios){
        List<AtividadeDiaria> refeicoes = new ArrayList<AtividadeDiaria>();

        for (RegistroDiario registroDiario : registroDiarios){
            refeicoes.addAll(registroDiario.getAtividasDiarias());
        }

        AdesaoData adesaoEmocao = new AdesaoData();

        for (AtividadeDiaria refeicao : refeicoes) {
            Boolean refeicaoFeita = refeicao.getAtividadeFeita();
            if (refeicaoFeita != null) {
                String tipoRefeicao = refeicao.getEmocao().toString();
                if (refeicaoFeita) {
                    adesaoEmocao.getFeito().put(tipoRefeicao, adesaoEmocao.getFeito().getOrDefault(tipoRefeicao, 0)+1);
                }
                else {
                    adesaoEmocao.getNaoFeito().put(tipoRefeicao, adesaoEmocao.getNaoFeito().getOrDefault(tipoRefeicao, 0)+1);
                }
            }

        }

        return adesaoEmocao;
    }

    @Override
    public Map<String, Integer> quantidadeSono(List<RegistroDiario> registroDiarios){
        Map<String, Integer> quantidadeSono = new HashMap<>();

        for (RegistroDiario registroDiario : registroDiarios){
            String tipoSono = registroDiario.getQualidadeSono().toString();
            if (!Objects.equals(tipoSono, "PENDENTE")){
                quantidadeSono.put(tipoSono, quantidadeSono.getOrDefault(tipoSono, 0)+1);
            }
        }
        return quantidadeSono;
    }

    @Override
    public Map<String, Integer> quantidadeEmocao(List<RegistroDiario> registroDiarios){
        List<AtividadeDiaria> refeicoes = new ArrayList<AtividadeDiaria>();

        for (RegistroDiario registroDiario : registroDiarios){
            refeicoes.addAll(registroDiario.getAtividasDiarias());
        }

        Map<String, Integer> quantidadeEmocao = new HashMap<>();

        for (AtividadeDiaria refeicao : refeicoes){
            String tipoEmocao = refeicao.getEmocao().toString();
            if (!Objects.equals(tipoEmocao, "PENDENTE")){
                quantidadeEmocao.put(tipoEmocao, quantidadeEmocao.getOrDefault(tipoEmocao, 0)+1);
            }
        }

        return quantidadeEmocao;
    }

    @Override
    public List<String> sintomas(List<RegistroDiario> registroDiarios){
        List<String> sintomas = new ArrayList<>();

        for (RegistroDiario registroDiario : registroDiarios){
            sintomas.addAll(registroDiario.getSintomas());
        }

        return sintomas;
    }
}
