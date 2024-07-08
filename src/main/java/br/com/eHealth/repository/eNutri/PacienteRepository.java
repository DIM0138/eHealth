package br.com.eHealth.repository.eNutri;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.repository.eHealth.UsuarioRepository;

@Repository
public interface PacienteRepository extends UsuarioRepository<Paciente> {
    List<Paciente> findByProfissionalResponsavelId(Long id);
}
