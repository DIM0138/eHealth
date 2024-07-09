package br.com.eHealth.controller.eHealth;

import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.service.eHealth.PlanoService;

import java.util.List;

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

   @GetMapping("{id}/ativar")
   public Boolean ativarPlano(@PathVariable Long id) {
      planoService.ativarPlano(id).toDTO();
      return true;
   }

   @DeleteMapping("/{id}")
   public Boolean deletarPlano(@PathVariable Long id) {
      return planoService.deletarPlano(id);
   }

   @PostMapping("{id}/atividade-diaria")
   public AtividadeDiariaDTO criarAtividadeDiaria(@RequestBody AtividadeDiariaDTO atividadeDiariaDTO, @PathVariable Long id) {
      return planoService.criarAtividadeDiaria(atividadeDiariaDTO, id).toDTO();
   }
//   public AtividadeDTO atualizarAtividade(@RequestBody A atividadeDTO) { return null; }

//   public Boolean deletarAtividade(@PathVariable Long id) { return null; }

   @PostMapping("atividades-diarias/responder")
   public AtividadeDiariaDTO responderAtividadeDiaria(@RequestBody AtividadeDiariaDTO atividadeDiariaDTO) {
      return planoService.responderAtividadeDiaria(atividadeDiariaDTO).toDTO();
   }

   @PostMapping("registros-diarios/responder")
   public RegistroDiarioDTO responderRegistroDiario(@RequestBody RegistroDiarioDTO registroDiarioDTO) {
      return planoService.responderRegistroDiario(registroDiarioDTO).toDTO();
   }

   @GetMapping("profissional/{id}")
   public List<PlanoDTO> buscarPlanosPorProfissionalId(@PathVariable Long id) {
      return planoService.buscarPlanosPorProfissionalId(id);
   }

//   public ResumoAtividadesDTO gerarResumoAtividades(@PathVariable Long id) { return null; }
}

