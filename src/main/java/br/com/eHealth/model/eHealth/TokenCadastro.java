package br.com.eHealth.model.eHealth;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.util.RandomTokenGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class TokenCadastro {

    @Id
    @JsonProperty("token")
    private String token;

    @JsonProperty("email")
    private String email;

    @JsonProperty("nome_paciente")
    private String nomePaciente;

    @JsonProperty("usado")
    private boolean usado;

    public TokenCadastro () {
        this.token = RandomTokenGenerator.generateRandomString();
        this.usado = false;
    }

    public String newToken() {
        this.token = RandomTokenGenerator.generateRandomString();

        return this.token;
    }

    public boolean isUsed() {
        return this.usado;
    }

}