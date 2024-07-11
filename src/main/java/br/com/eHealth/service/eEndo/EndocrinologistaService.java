package br.com.eHealth.service.eEndo;

import br.com.eHealth.model.eEndo.Endocrinologista;
import br.com.eHealth.model.eEndo.dto.EndocrinologistaDTO;
import br.com.eHealth.service.eHealth.UsuarioService;
import org.springframework.stereotype.Service;

@Service
public class EndocrinologistaService extends UsuarioService<Endocrinologista, EndocrinologistaDTO> {
}
