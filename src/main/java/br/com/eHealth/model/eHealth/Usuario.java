package br.com.eHealth.model.eHealth;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@SuperBuilder
@NoArgsConstructor
@ToString
public abstract class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @JsonProperty("id")
    private long id;

    @Column (nullable = false, unique = true)
    @JsonProperty("login")
    private String login;

    @Column (nullable = false, unique = true)
    @JsonProperty("email")
    private String email;

    @Column (nullable = false)
    @JsonProperty("nome_completo")
    private String nomeCompleto;

    @Column (nullable = false, unique = true)
    @JsonProperty("cpf")
    private String CPF;

    @Column (nullable = false)
    @JsonProperty("senha")
    private String senha;

    @JsonProperty("data_nascimento")
    private LocalDate dataNascimento;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("endereco")
    private String endereco;

    @JsonProperty("telefone")
    private String telefone;

    public abstract UsuarioDTO toDTO();
}
