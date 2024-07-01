package br.com.eHealth.service.eHealth;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;

public abstract class PlanoStrategy<P extends PlanoDTO, R extends RegistroDiarioDTO, A extends AtividadeDTO> {
    
    public abstract P criarPlano(P planoDTO);
    public abstract P ativarPlano(Long id);
    public abstract Boolean deletarPlano(Long id);
    public abstract A criarAtividade(A atividadeDTO);
    public abstract A atualizarAtividade(A atividadeDTO);
    public abstract Boolean deletarAtividade(Long id);
    public abstract A responderAtividade(A atividadeDTO);
    public abstract R responderRegistroDiario(R registroDiarioDTO);
    public abstract List<P> buscarPlanosPorProfissionalId(Long id);
    public abstract ResumoAtividadesDTO gerarResumoAtividades(Long id);
}
