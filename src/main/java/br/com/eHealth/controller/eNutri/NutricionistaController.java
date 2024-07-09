/*
 * NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
 * */
package br.com.eHealth.controller.eNutri;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/enutri/nutricionistas")
public class NutricionistaController extends UsuarioController<Nutricionista, NutricionistaDTO> {

}
