package br.com.eHealth.repository.eHealth;

import br.com.eHealth.model.eHealth.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Plano;

import java.util.List;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    public List<Plano> getByProfissionalResponsavel(Profissional profissional);
}
