package br.com.eHealth.repository.eNutri;

import br.com.eHealth.model.eNutri.Receita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceitaRepository extends JpaRepository<Receita, Long> {
    
}
