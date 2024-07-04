package br.com.eHealth.service.eHealth;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;

@Component
public abstract class PlanoService<P extends PlanoDTO, R extends RegistroDiarioDTO, A extends AtividadeDTO> {
    protected PlanoStrategy<P, R, A> planoStrategy;

    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        return null;
    }

    public PlanoDTO ativarPlano(Long id) {
        return null;
    }
    public Boolean deletarPlano(Long id) {
        return null;
    }

    public AtividadeDTO criarAtividade(AtividadeDTO atividadeDTO) {
        return null;
    }

    public AtividadeDTO atualizarAtividade(AtividadeDTO atividadeDTO) {
        return null;
    }

    public Boolean deletarAtividade(Long id) {
        return null;
    }

    public AtividadeDTO responderAtividade(AtividadeDTO atividadeDTO) {
        return null;
    }

    public RegistroDiarioDTO responderRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        return null;
    }

    public List<PlanoDTO> buscarPlanosPorProfissionalId(Long id) {
        return null;
    }

    public ResumoAtividadesDTO gerarResumoAtividades(Long id) {
        return null;
    }

}
