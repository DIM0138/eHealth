package br.com.eHealth.service.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.service.eHealth.UsuarioService;

@Service
public class NutricionistaService extends UsuarioService<Nutricionista, NutricionistaDTO> {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public Boolean existePorCRN(String CRN) {
        return this.nutricionistaRepository.existsByCRN(CRN);
    }
}
