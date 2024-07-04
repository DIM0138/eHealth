package br.com.eHealth.model.eHealth.dto;

import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class TokenCadastroDTO {
    
    @JsonProperty("token")
    private Optional<String> token;

    @JsonProperty("email")
    private Optional<String> email;

    @JsonProperty("nome_paciente")
    private Optional<String> nomePaciente;

    @JsonProperty("profissional_responsavel")
    private Optional<Long> profissionalResponsavel;

    @JsonProperty("usado")
    private Optional<Boolean> usado;
}
