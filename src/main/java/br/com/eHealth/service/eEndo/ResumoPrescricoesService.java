package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.ItemResumo;
import br.com.eHealth.model.eEndo.ResumoPrescricoes;
import br.com.eHealth.model.eHealth.AtividadeDiaria;
import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.ResumoAtividades;
import br.com.eHealth.service.eHealth.PlanoService;
import br.com.eHealth.service.eHealth.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class ResumoPrescricoesService extends ResumoService {

    @Autowired
    private PlanoService planoService;

    @Override
    public ResumoAtividades gerarResumo(Long idPlano) {
        Plano plano = planoService.buscarPorId(idPlano);
        List<RegistroDiario> registrosDiarios = plano.getRegistrosDiarios();

        ResumoPrescricoes resumoPrescricoes = new ResumoPrescricoes();
        List<ItemResumo> itensResumo = new ArrayList<>();

        for (RegistroDiario registro : registrosDiarios) {
            ItemResumo itemResumo = new ItemResumo();
            itemResumo.setData(registro.getData());
            for (AtividadeDiaria atividade : registro.getAtividasDiarias()) {
                if (atividade.getTratamento() != null) {
                    itemResumo.adicionarMedicamento(atividade.getTratamento().getNome(), atividade.getHorario());
                }
            }
            itensResumo.add(itemResumo);
        }
        resumoPrescricoes.setItemResumo(itensResumo);
        return resumoPrescricoes;
    }
}
