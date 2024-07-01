package br.com.eHealth.repository.eNutri;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import br.com.eHealth.model.eHealth.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long>{
    List<Paciente> findByProfissionalResponsavelId(Long id);
}
