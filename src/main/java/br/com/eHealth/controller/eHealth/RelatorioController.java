package br.com.eHealth.controller.eHealth;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.eHealth.model.eHealth.Medicao;
import br.com.eHealth.model.eHealth.MedicaoRelatorio;
import br.com.eHealth.model.eHealth.Relatorio;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import br.com.eHealth.service.eHealth.RelatorioService;

public class RelatorioController<T extends Relatorio, DTO extends RelatorioDTO, M extends Medicao, MR extends MedicaoRelatorio> {
    
    @Autowired
    private RelatorioService<T, DTO, M, MR> relatorioService;

    @PostMapping
    public RelatorioDTO criar(@RequestBody DTO relatorioDTO) {
        return this.relatorioService.criar(relatorioDTO);
    }

    @PatchMapping("/{id}")
    public RelatorioDTO atualizar(@RequestBody DTO relatorioDTO, @PathVariable Long id) {
        return this.relatorioService.atualizar(relatorioDTO, id);
    }

    @DeleteMapping("/{id}")
    public Boolean deletar(@PathVariable Long id) {
        return this.relatorioService.deletar(id);
    }

    @GetMapping("/{id}")
    public RelatorioDTO buscarPorId(@PathVariable Long id) {
        return this.relatorioService.buscarPorId(id).toDTO();
    }

    @GetMapping("/paciente/{idPaciente}")
    public ArrayList<RelatorioDTO> buscarPorPaciente(@PathVariable Long idPaciente) {
        return this.relatorioService.buscarPorPacienteId(idPaciente);
    }
}
