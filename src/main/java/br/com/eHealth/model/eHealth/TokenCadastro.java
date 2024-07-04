package br.com.eHealth.model.eHealth;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.util.RandomTokenGenerator;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class TokenCadastro {

    @Id
    @JsonProperty("token")
    private String token;

    @JsonProperty("email")
    @Column(unique = true, nullable = false)
    private String email;

    @JsonProperty("nome_paciente")
    @Column(nullable = false)
    private String nomePaciente;

    @JsonProperty("profissional_responsavel")
    @ManyToOne
    @JoinColumn(nullable = false, name = "profissional_id")
    private Profissional profissionalResponsavel;

    @JsonProperty("usado")
    private boolean usado = false;

    public TokenCadastro () {
        this.token = RandomTokenGenerator.generateRandomString();
        this.usado = false;
    }

    public String newToken() {
        this.token = RandomTokenGenerator.generateRandomString();

        return this.token;
    }

    public TokenCadastroDTO toDTO() {
        TokenCadastroDTO tokenDTO = new TokenCadastroDTO();

        tokenDTO.setToken(Optional.ofNullable(this.token));
        tokenDTO.setEmail(Optional.ofNullable(this.email));
        tokenDTO.setNomePaciente(Optional.ofNullable(this.nomePaciente));
        tokenDTO.setProfissionalResponsavel(Optional.ofNullable(this.profissionalResponsavel.getId()));
        tokenDTO.setUsado(Optional.ofNullable(this.usado));

        return tokenDTO;
    }

}