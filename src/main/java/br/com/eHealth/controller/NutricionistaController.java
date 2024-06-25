package br.com.eHealth.controller;

import br.com.eHealth.model.Nutricionista;
import br.com.eHealth.model.dto.NutricionistaDTO;
import br.com.eHealth.service.NutricionistaService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {
    @Autowired
    private NutricionistaService nutricionistaService;

    @PostMapping("/novo")
    public ResponseEntity<Nutricionista> addNutricionista(@RequestBody NutricionistaDTO nutricionistaDTO, HttpServletRequest request) {

        Nutricionista novoNutricionista = nutricionistaService.save(nutricionistaDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(novoNutricionista);
    }

}
