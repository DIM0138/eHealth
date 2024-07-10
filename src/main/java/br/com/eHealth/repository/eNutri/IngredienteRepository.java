package br.com.eHealth.repository.eNutri;

import br.com.eHealth.model.eNutri.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Long> {
    Ingrediente findOneByNomeIgnoreCaseAndMedida(String nome, Ingrediente.TipoMedida medida);
}
