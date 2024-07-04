package br.com.eHealth.repository.eNutri;

import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

@Repository
public interface NutricionistaRepository extends UsuarioRepository<Nutricionista> {
    Boolean existsByCRN(String crn);
}
