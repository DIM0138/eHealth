package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Plano;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    
}