package br.com.eHealth.service.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.service.eHealth.ProfissionalService;

@Service
public class NutricionistaService extends ProfissionalService<NutricionistaDTO> {
    
    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public NutricionistaService(@Autowired NutricionistaStrategy nutricionistaStrategy) {
        super(nutricionistaStrategy);
    }

    public List<PacienteDTO> buscarPacientesPorProfissionalId(Long id) {

        return this.strategy.buscarPacientesPorProfissionalId(id);
    }

    public Boolean existeCrn(String crn) {
        return nutricionistaRepository.existsByCRN(crn);
    }

}
