package br.com.eHealth.repository.eHealth;

import br.com.eHealth.model.eHealth.AtividadeDiaria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AtividadeDiariaRepository extends JpaRepository<AtividadeDiaria, Long> {
}
