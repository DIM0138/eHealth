package br.com.eHealth.repository.eHealth;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eHealth.Plano;

import java.util.List;
import java.util.Optional;

public interface PlanoRepository extends JpaRepository<Plano, Long> {
    public List<Plano> getByProfissionalResponsavel(Profissional profissional);
    public List<Plano> getByPaciente(Paciente paciente);
    public Optional<Plano> findByAtivoAndPacienteId(Boolean ativo, Long pacienteId);
}
