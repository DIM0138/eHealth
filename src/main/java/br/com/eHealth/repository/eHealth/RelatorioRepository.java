package br.com.eHealth.repository.eHealth;

import java.time.LocalDate;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Relatorio;

@Repository
public interface RelatorioRepository<T extends Relatorio> extends JpaRepository<T, Long>{
    Boolean existsByDataConsultaAndPacienteId(LocalDate data, Long id);
}
