package br.com.eHealth.model.eHealth.dto;

import java.time.LocalDate;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import br.com.eHealth.model.eHealth.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class UsuarioDTO {

    @JsonProperty("id")
    private Optional<Long> id;

    @JsonProperty("token")
    private Optional<String> token;

    @JsonProperty("nome_completo")
    private Optional<String> nomeCompleto;

    @JsonProperty("genero")
    private Optional<String> genero;

    @JsonProperty("data_nascimento")
    private Optional<LocalDate> dataNascimento;

    @JsonProperty("endereco")
    private Optional<String> endereco;

    @JsonProperty("telefone")
    private Optional<String> telefone;

    @JsonProperty("email")
    private Optional<String> email;

    @JsonProperty("cpf")
    private Optional<String> CPF;

    @JsonProperty("login")
    private Optional<String> login;

    @JsonProperty("senha")
    private Optional<String> senha;

    public UsuarioDTO(Usuario usuario) {
        this.id = Optional.ofNullable(usuario.getId());
        this.nomeCompleto = Optional.ofNullable(usuario.getNomeCompleto());
        this.genero = Optional.ofNullable(usuario.getGenero());
        this.dataNascimento = Optional.ofNullable(usuario.getDataNascimento());
        this.endereco = Optional.ofNullable(usuario.getEndereco());
        this.telefone = Optional.ofNullable(usuario.getTelefone());
        this.email = Optional.ofNullable(usuario.getEmail());
        this.CPF = Optional.ofNullable(usuario.getCPF());
        this.login = Optional.ofNullable(usuario.getLogin());
        this.senha = Optional.ofNullable(usuario.getSenha());
    }
}
