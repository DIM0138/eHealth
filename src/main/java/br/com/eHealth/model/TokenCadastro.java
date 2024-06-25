package br.com.eHealth.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import br.com.eHealth.util.RandomTokenGenerator;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
@JsonIdentityInfo(scope = TokenCadastro.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "token")
public class TokenCadastro {

    @Id
    private String token;

    @OneToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

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