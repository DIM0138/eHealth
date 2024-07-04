package br.com.eHealth.controller.eHealth;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;
import br.com.eHealth.service.eHealth.PlanoService;

public abstract class PlanoController<P extends PlanoDTO, R extends RegistroDiarioDTO, A extends AtividadeDTO> {

   public PlanoService<P, R, A> planoService;

   public Plano criarPlano(@RequestBody P planoDTO) {
      return null;
   }

   public Plano ativarPlano(@PathVariable Long id) { return null; }
   public Boolean deletarPlano(@PathVariable Long id) { return null; }
   public AtividadeDTO criarAtividade(@RequestBody A atividadeDTO) { return null; }
   public AtividadeDTO atualizarAtividade(@RequestBody A atividadeDTO) { return null; }
   public Boolean deletarAtividade(@PathVariable Long id) { return null; }
   public AtividadeDTO responderAtividade(@RequestBody A atividadeDTO) { return null; }
   public RegistroDiarioDTO responderRegistroDiario(@RequestBody R registroDiarioDTO) { return null; }
   public List<P> buscarPlanosPorProfissionalId(@PathVariable Long id) { return null; }
   public ResumoAtividadesDTO gerarResumoAtividades(@PathVariable Long id) { return null; }
}

