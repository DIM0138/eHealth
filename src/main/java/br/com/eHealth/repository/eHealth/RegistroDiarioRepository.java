package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eHealth.RegistroDiario;

public interface RegistroDiarioRepository<T extends RegistroDiario> extends JpaRepository<T, Long> {

    
}