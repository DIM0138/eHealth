package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.RegistroDiario;

public interface RegistroDiarioRepository extends JpaRepository<RegistroDiario, Long> {
    Optional<RegistroDiario> findByPlanoAndData(Plano plano, LocalDate data);
    
}