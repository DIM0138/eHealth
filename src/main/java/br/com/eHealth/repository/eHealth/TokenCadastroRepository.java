package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.eHealth.model.eHealth.TokenCadastro;

public interface TokenCadastroRepository extends JpaRepository<TokenCadastro, String> {
    public Boolean existsByEmail(String email);
}
