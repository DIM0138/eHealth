package br.com.eHealth.model.eHealth.dto;

import java.time.LocalDate;

import br.com.eHealth.model.eHealth.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {
    private long id;
    private String nomeCompleto;
    private String genero;
    private LocalDate dataNascimento;
    private String endereco;
    private String telefone;
    private String email;
    private String cpf;
    private String login;
    private String senha;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nomeCompleto = usuario.getNomeCompleto();
        this.genero = usuario.getGenero();
        this.dataNascimento = usuario.getDataNascimento();
        this.endereco = usuario.getEndereco();
        this.telefone = usuario.getTelefone();
        this.email = usuario.getEmail();
        this.cpf = usuario.getCPF();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
    }
}
