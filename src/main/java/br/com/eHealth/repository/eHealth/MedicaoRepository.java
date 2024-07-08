package br.com.eHealth.repository.eHealth;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Medicao;

@Repository
public interface MedicaoRepository<T extends Medicao> extends JpaRepository<T, Long> {
    public Optional<T> findOneByNomeIgnoreCaseAndUnidadeIgnoreCase(String nome, String unidade);
}
