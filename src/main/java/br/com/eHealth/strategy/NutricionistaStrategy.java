/*
 * NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
 * */

package br.com.eHealth.strategy;

import br.com.eHealth.model.Nutricionista;
import br.com.eHealth.model.Profissional;
import br.com.eHealth.model.dto.NutricionistaDTO;
import br.com.eHealth.model.dto.ProfissionalDTO;
import br.com.eHealth.repository.NutricionistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class NutricionistaStrategy implements ProfissionalStrategy{

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Override
    public Profissional criar(ProfissionalDTO profissionalDTO) {
        Nutricionista novoNutricionista = new Nutricionista();

        NutricionistaDTO nutricionistaDTO = (NutricionistaDTO) profissionalDTO;

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

        return nutricionistaRepository.save(novoNutricionista);
    }

    @Override
    public List<Profissional> listarTodos() {
        List<Nutricionista> nutricionistas =  nutricionistaRepository.findAll();
        return new ArrayList<>(nutricionistas);
    }

}
