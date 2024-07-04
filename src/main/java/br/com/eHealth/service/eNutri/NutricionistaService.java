package br.com.eHealth.service.eNutri;

import org.springframework.stereotype.Service;

import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.service.eHealth.UsuarioService;

@Service
public class NutricionistaService extends UsuarioService<Nutricionista, NutricionistaDTO> {

}
