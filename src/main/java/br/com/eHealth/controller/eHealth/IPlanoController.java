package br.com.eHealth.controller.eHealth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;

public abstract interface IPlanoController<P extends PlanoDTO, R extends RegistroDiarioDTO, A extends AtividadeDTO> {

   public abstract P criarPlano(@RequestBody P planoDTO);
   public abstract P ativarPlano(@PathVariable Long id);
   public abstract Boolean deletarPlano(@PathVariable Long id);
   public abstract A criarAtividade(@RequestBody A atividadeDTO);
   public abstract A atualizarAtividade(@RequestBody A atividadeDTO);
   public abstract Boolean deletarAtividade(@PathVariable Long id);
   public abstract A responderAtividade(@RequestBody A atividadeDTO);
   public abstract R responderRegistroDiario(@RequestBody R registroDiarioDTO);
   public abstract List<P> buscarPlanosPorProfissionalId(@PathVariable Long id);
   public abstract ResumoAtividadesDTO gerarResumoAtividades(@PathVariable Long id);
}
