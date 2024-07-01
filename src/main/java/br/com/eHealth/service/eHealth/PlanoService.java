package br.com.eHealth.service.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;
import br.com.eHealth.model.eHealth.factory.PlanoFactory;

public abstract class PlanoService {
    protected PlanoStrategy<PlanoDTO, RegistroDiarioDTO, AtividadeDTO> strategy;
    protected PlanoFactory factory;

    public PlanoService(PlanoStrategy<PlanoDTO, RegistroDiarioDTO, AtividadeDTO> strategy, PlanoFactory factory) {
        this.strategy = strategy;
        this.factory = factory;
    }

    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        return strategy.criarPlano(planoDTO);
    }

    public PlanoDTO ativarPlano(Long id) {
        return strategy.ativarPlano(id);
    }
    public Boolean deletarPlano(Long id) {
        return strategy.deletarPlano(id);
    }

    public AtividadeDTO criarAtividade(AtividadeDTO atividadeDTO) {
        return strategy.criarAtividade(atividadeDTO);
    }

    public AtividadeDTO atualizarAtividade(AtividadeDTO atividadeDTO) {
        return strategy.atualizarAtividade(atividadeDTO);
    }

    public Boolean deletarAtividade(Long id) {
        return strategy.deletarAtividade(id);
    }

    public AtividadeDTO responderAtividade(AtividadeDTO atividadeDTO) {
        return strategy.responderAtividade(atividadeDTO);
    }

    public RegistroDiarioDTO responderRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        return strategy.responderRegistroDiario(registroDiarioDTO);
    }

    public List<PlanoDTO> buscarPlanosPorProfissionalId(Long id) {
        return strategy.buscarPlanosPorProfissionalId(id);
    }

    public ResumoAtividadesDTO gerarResumoAtividades(Long id) {
        return strategy.gerarResumoAtividades(id);
    }

}
