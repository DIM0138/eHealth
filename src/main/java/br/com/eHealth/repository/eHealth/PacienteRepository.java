package br.com.eHealth.repository.eHealth;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Paciente;

@Repository
public interface PacienteRepository extends UsuarioRepository<Paciente> {
    List<Paciente> findByProfissionalResponsavelId(Long id);
}
