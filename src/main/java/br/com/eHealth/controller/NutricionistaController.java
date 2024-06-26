/*
 * NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
 * */
package br.com.eHealth.controller;

import br.com.eHealth.model.Nutricionista;
import br.com.eHealth.model.Profissional;
import br.com.eHealth.model.dto.NutricionistaDTO;
import br.com.eHealth.model.dto.ProfissionalDTO;
import br.com.eHealth.service.ProfissionalService;
import br.com.eHealth.strategy.NutricionistaStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    private final ProfissionalService profissionalService;

    @Autowired
    public NutricionistaController(NutricionistaStrategy nutricionistaStrategy) {
        this.profissionalService = new ProfissionalService(nutricionistaStrategy);
    }

    @PostMapping
    public ResponseEntity<NutricionistaDTO> criar(@RequestBody NutricionistaDTO nutricionistaDTO) {
        Nutricionista nutricionistaSalvo = (Nutricionista) profissionalService.criarProfissional(nutricionistaDTO);
        NutricionistaDTO nutricionistaSalvoDTO = new NutricionistaDTO(nutricionistaSalvo);
        return ResponseEntity.status(HttpStatus.CREATED).body(nutricionistaSalvoDTO);
    }

    @GetMapping
    public ResponseEntity<List<NutricionistaDTO>> listarTodos() {
        List<Profissional> profissionais = profissionalService.listarTodos();

        List<NutricionistaDTO> nutricionistasDTO = profissionais.stream().map(
                profissional -> new NutricionistaDTO((Nutricionista) profissional)
        ).collect(Collectors.toList());
        return ResponseEntity.ok(nutricionistasDTO);
    }
}
