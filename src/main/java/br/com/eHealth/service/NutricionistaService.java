package br.com.eHealth.service;

import br.com.eHealth.model.Nutricionista;
import br.com.eHealth.model.dto.NutricionistaDTO;
import br.com.eHealth.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NutricionistaService {

    @Autowired
    public NutricionistaRepository nutricionistas;

    public Nutricionista save(NutricionistaDTO nutricionistaDTO){
        Nutricionista novoNutricionista = new Nutricionista();

        novoNutricionista.setNomeCompleto(nutricionistaDTO.getNomeCompleto());
        novoNutricionista.setGenero(nutricionistaDTO.getGenero());
        novoNutricionista.setDataNascimento(nutricionistaDTO.getDataNascimento());
        novoNutricionista.setEndereco(nutricionistaDTO.getEndereco());
        novoNutricionista.setTelefone(nutricionistaDTO.getTelefone());
        novoNutricionista.setEmail(nutricionistaDTO.getEmail());
        novoNutricionista.setCPF(nutricionistaDTO.getCpf());
        novoNutricionista.setLogin(nutricionistaDTO.getLogin());
        novoNutricionista.setSenha(nutricionistaDTO.getSenha());
        novoNutricionista.setCRN(nutricionistaDTO.getCRN());
        novoNutricionista.setFormacao(nutricionistaDTO.getFormacao());
        novoNutricionista.setEspecialidade(nutricionistaDTO.getEspecialidade());
        novoNutricionista.setEnderecoProfissional(nutricionistaDTO.getEnderecoProfissional());

        nutricionistas.save(novoNutricionista);

        return novoNutricionista;
    }

}
