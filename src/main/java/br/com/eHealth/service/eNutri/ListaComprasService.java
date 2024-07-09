package br.com.eHealth.service.eNutri;

import br.com.eHealth.model.eHealth.AtividadeDiaria;
import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.ResumoAtividades;
import br.com.eHealth.model.eNutri.*;
import br.com.eHealth.repository.eHealth.PlanoRepository;
import br.com.eHealth.repository.eNutri.ReceitaRepository;
import br.com.eHealth.service.eHealth.PlanoService;
import br.com.eHealth.service.eHealth.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ListaComprasService extends ResumoService {

    @Autowired
    private ReceitaRepository receitaRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private PlanoService planoService;

    private List<Receita> filtrarReceitasDoPlano(Plano plano){
        List<Receita> receitas = new ArrayList<>();
        for (RegistroDiario registroDiario : plano.getRegistrosDiarios()){
            for (AtividadeDiaria atividadeDiaria : registroDiario.getAtividasDiarias()){
                receitas.add((Receita) atividadeDiaria.getTratamento());
            }
        }
        return receitas;
    }

    @Override
    public ResumoAtividades gerarResumo(Long idPlano) {
        Plano plano = planoService.buscarPorId(idPlano);
        List<Receita> receitas = filtrarReceitasDoPlano(plano);

        Map<Ingrediente, Integer> quantidadeIngredientes = new HashMap<>();

        for (Receita receita : receitas){
            for (IngredienteReceita ingredienteReceita : receita.getIngredientes()) {
                Ingrediente ingrediente = ingredienteReceita.getIngrediente();
                Integer quantidade = ingredienteReceita.getQuantidade();

                quantidadeIngredientes.put(ingrediente, quantidadeIngredientes.getOrDefault(ingrediente,0)+quantidade);
            }
        }

        List<ItemListaCompras> itens = new ArrayList<>();
        for (Map.Entry<Ingrediente, Integer> entry : quantidadeIngredientes.entrySet()) {
            Ingrediente ingrediente = entry.getKey();
            Integer quantidade = entry.getValue();

            ItemListaCompras item = new ItemListaCompras();
            if (ingrediente.getNome() != null){
                item.setIngrediente(ingrediente.getNome());
                item.setMetrica(String.valueOf(ingrediente.getMedida()));
            }
            item.setQuantidadeTotal(quantidade);

            itens.add(item);
        }
        ListaCompras listaCompras = new ListaCompras();
        listaCompras.setItens(itens);

        return listaCompras;
    }
}
