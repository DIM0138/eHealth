package br.com.eHealth.controller.eHealth;

import br.com.eHealth.model.eHealth.ResumoAtividades;
import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.service.eHealth.ResumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.service.eHealth.PlanoService;

import java.util.List;
import java.time.LocalDate;

@RestController
@RequestMapping("/planos")
public class PlanoController{

   @Autowired
   private PlanoService planoService;

   @Autowired
   private ResumoService resumoService;

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
      System.out.println(atividadeDiariaDTO);
      return planoService.criarAtividadeDiaria(atividadeDiariaDTO, id).toDTO();
   }

   @DeleteMapping("atividades-diarias/{id}")
   public Boolean deletarAtividade(@PathVariable Long id) { 
      return planoService.deletarAtividade(id);
   }

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

   @GetMapping("resumo/{id}")
   public ResumoAtividades gerarResumoAtividades(@PathVariable Long id) {
      return resumoService.gerarResumo(id);
   }

   @GetMapping("/paciente/{id}")
   public PlanoDTO buscarPlanoPorPacienteId(@PathVariable("id") Long id){

      return planoService.buscarPlanoAtualPorPacienteId(id).toDTO();
    }

    @GetMapping("/paciente/{id}/registro-diario")
    public RegistroDiarioDTO buscarRegistroDiarioPorPacienteEData(@PathVariable("id") Long id, @RequestParam("data") @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate data){

        return planoService.buscarRegistroDiarioPorPacienteEData(id, data);
    }
}

