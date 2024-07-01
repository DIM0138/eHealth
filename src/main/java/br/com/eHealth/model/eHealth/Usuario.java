package br.com.eHealth.model.eHealth;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column (unique = true)
    private String login;
    @Column (unique = true)
    private String email;
    @Column (nullable = false)
    private String nomeCompleto;
    @Column (unique = true)
    private String CPF;
    @Column (nullable = false)
    private String senha;
    
    private LocalDate dataNascimento;
    private String genero;
    private String endereco;
    private String telefone;
}
