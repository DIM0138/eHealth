package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.MedicaoRelatorio;

@Repository
public interface MedicaoRelatorioRepository<T extends MedicaoRelatorio> extends JpaRepository<T, Long> {
    
}
