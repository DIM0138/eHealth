package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Plano;

@Repository
public interface PlanoRepository<T extends Plano> extends JpaRepository<T, Long> {
    
}
