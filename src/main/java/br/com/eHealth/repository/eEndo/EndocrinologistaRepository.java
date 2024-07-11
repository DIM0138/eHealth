package br.com.eHealth.repository.eEndo;

import br.com.eHealth.model.eEndo.Endocrinologista;
import br.com.eHealth.repository.eHealth.UsuarioRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EndocrinologistaRepository extends UsuarioRepository<Endocrinologista> {
    Boolean existsByCRM(String crm);
}
