package br.com.eHealth.repository.eHealth;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.eHealth.model.eHealth.TokenCadastro;
import java.util.List;


@Repository
public interface TokenCadastroRepository extends JpaRepository<TokenCadastro, String> {
    public Boolean existsByEmail(String email);
    List<TokenCadastro> findByProfissionalResponsavelId(Long id);
}
