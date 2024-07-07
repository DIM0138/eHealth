package br.com.eHealth.controller.eHealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.service.eHealth.PlanoService;

@RestController
@RequestMapping("/planos")
public class PlanoController{

   @Autowired
   public PlanoService planoService;

   @PostMapping
   public PlanoDTO criar(@RequestBody PlanoDTO planoDTO) {
      return planoService.criarPlano(planoDTO);
   }

   @GetMapping("/{id}")
   public PlanoDTO buscarPorId(@PathVariable Long id){
      return planoService.buscarPorId(id).toDTO();
   }
//
//   public Plano ativarPlano(@PathVariable Long id) { return null; }
//   public Boolean deletarPlano(@PathVariable Long id) { return null; }
//   public AtividadeDTO criarAtividade(@RequestBody A atividadeDTO) { return null; }
//   public AtividadeDTO atualizarAtividade(@RequestBody A atividadeDTO) { return null; }
//   public Boolean deletarAtividade(@PathVariable Long id) { return null; }
//   public AtividadeDTO responderAtividade(@RequestBody A atividadeDTO) { return null; }
//   public RegistroDiarioDTO responderRegistroDiario(@RequestBody R registroDiarioDTO) { return null; }
//   public List<P> buscarPlanosPorProfissionalId(@PathVariable Long id) { return null; }
//   public ResumoAtividadesDTO gerarResumoAtividades(@PathVariable Long id) { return null; }
}

