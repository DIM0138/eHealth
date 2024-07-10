package br.com.eHealth.service.eFit;

import org.springframework.stereotype.Service;

import br.com.eHealth.model.eFit.Instrutor;
import br.com.eHealth.model.eFit.dto.InstrutorDTO;
import br.com.eHealth.service.eHealth.UsuarioService;

@Service
public class InstrutorService extends UsuarioService<Instrutor, InstrutorDTO> {
    
}
