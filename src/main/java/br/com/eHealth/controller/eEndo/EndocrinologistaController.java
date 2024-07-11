package br.com.eHealth.controller.eEndo;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eEndo.Endocrinologista;
import br.com.eHealth.model.eEndo.dto.EndocrinologistaDTO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/endo/endocrinologistas")
public class EndocrinologistaController extends UsuarioController<Endocrinologista, EndocrinologistaDTO> {
}
