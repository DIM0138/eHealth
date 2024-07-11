package br.com.eHealth.controller.eHealth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.eHealth.model.eHealth.dto.TokenCadastroDTO;
import br.com.eHealth.service.eHealth.TokenCadastroService;

import java.util.List;

@RestController
@RequestMapping("/tokens")
public class TokenCadastroController {

    @Autowired
    private TokenCadastroService tokenService;

    @PostMapping
    public TokenCadastroDTO novoToken(@RequestBody TokenCadastroDTO token) {
        return this.tokenService.novoToken(token);
    }

    @GetMapping("/{id}")
    public TokenCadastroDTO buscarToken(@PathVariable String id) {
        return this.tokenService.buscarToken(id).toDTO();
    }

    @GetMapping("/profissional/{id}")
    public List<TokenCadastroDTO> buscarTokenPorProfissionalId(@PathVariable Long id) {
        return this.tokenService.buscarTokensPorProfissionalId(id);
    }

    @DeleteMapping("/{id}")
    public Boolean deletarToken(@PathVariable String id) {
        return this.tokenService.deletarToken(id);
    }
}
