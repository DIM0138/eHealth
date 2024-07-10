package br.com.eHealth.controller.eFit;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.controller.eHealth.UsuarioController;
import br.com.eHealth.model.eFit.Instrutor;
import br.com.eHealth.model.eFit.dto.InstrutorDTO;

@RestController
@RequestMapping("/efit/instrutores")
public class InstrutorController extends UsuarioController<Instrutor, InstrutorDTO> {
    
}
