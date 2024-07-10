package br.com.eHealth.repository.eFit;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eFit.Exercicio;

public interface ExercicioRepository extends JpaRepository<Exercicio, Long> {
    
}
