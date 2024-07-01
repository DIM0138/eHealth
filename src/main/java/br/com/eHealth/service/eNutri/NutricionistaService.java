package br.com.eHealth.service.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.service.eHealth.ProfissionalService;

@Service
public class NutricionistaService extends ProfissionalService {
    
    public NutricionistaService(@Autowired NutricionistaStrategy nutricionistaStrategy) {
        super(nutricionistaStrategy);
    }

}
