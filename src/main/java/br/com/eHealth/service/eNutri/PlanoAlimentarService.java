package br.com.eHealth.service.eNutri;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.eHealth.model.eNutri.factory.PlanoAlimentarFactory;
import br.com.eHealth.service.eHealth.PlanoService;

@Service
public class PlanoAlimentarService extends PlanoService {

    public PlanoAlimentarService(@Autowired PlanoAlimentarStrategy strategy, @Autowired PlanoAlimentarFactory factory) {
        super(strategy, factory);
    }
    
}
