package br.com.eHealth.repository.eHealth;

import br.com.eHealth.model.eHealth.Tratamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TratamentoRepository<T extends Tratamento> extends JpaRepository<T, Long> {
}
