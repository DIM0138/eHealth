package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eHealth.Usuario;

public interface UsuarioRepository<T extends Usuario> extends JpaRepository<T, Long> {

    T findByLogin(String login);
    boolean existsByCPF(String string);
    boolean existsByEmail(String string);
    boolean existsByLogin(String string);
}
