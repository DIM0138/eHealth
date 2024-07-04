package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eHealth.Plano;

public interface PlanoRepository<T extends Plano> extends JpaRepository<T, Long> {
    
}
