package br.com.eHealth.controller.eHealth;

import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import br.com.eHealth.service.eHealth.TratamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class TratamentoController<T extends Tratamento, DTO extends TratamentoDTO> {

    @Autowired
    protected TratamentoService<T, DTO> tratamentoService;


    @PostMapping
    public TratamentoDTO criar(@RequestBody DTO tratamentoDTO){
        return tratamentoService. criar(tratamentoDTO);
    }

    @GetMapping("/{id}")
    public TratamentoDTO buscarPorId(@PathVariable long id){
        return tratamentoService.buscarPorId(id).toDTO();
    }

    @GetMapping("/todos")
    public List<TratamentoDTO> buscarTodos(){
        return tratamentoService.buscarTodos();
    }

    @PatchMapping("/{id}")
    public TratamentoDTO atualizar(@PathVariable("id") Long id, @RequestBody DTO tratamentoDTO){
        return tratamentoService.atualizar(id, tratamentoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        tratamentoService.deletar(id);
        return new ResponseEntity<>("Tratamento deletado.", HttpStatus.NO_CONTENT);
    }

}
