package br.com.eHealth.controller.eHealth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;

public abstract interface IPlanoController {

   public abstract PlanoDTO criarPlano(@RequestBody PlanoDTO planoDTO);
   public abstract PlanoDTO ativarPlano(@PathVariable Long id);
   public abstract Boolean deletarPlano(@PathVariable Long id);
   public abstract AtividadeDTO criarAtividade(@RequestBody AtividadeDTO atividadeDTO);
   public abstract AtividadeDTO atualizarAtividade(@RequestBody AtividadeDTO atividadeDTO);
   public abstract Boolean deletarAtividade(@PathVariable Long id);
   public abstract AtividadeDTO responderAtividade(@RequestBody AtividadeDTO atividadeDTO);
   public abstract RegistroDiarioDTO responderRegistroDiario(@RequestBody RegistroDiarioDTO registroDiarioDTO);
   public abstract List<PlanoDTO> buscarPlanosPorProfissionalId(@PathVariable Long id);
   public abstract ResumoAtividadesDTO gerarResumoAtividades(@PathVariable Long id);
}
