package br.com.eHealth.repository.eNutri;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

public interface PacienteRepository extends UsuarioRepository<Paciente> {
    List<Paciente> findByProfissionalResponsavelId(Long id);
}
