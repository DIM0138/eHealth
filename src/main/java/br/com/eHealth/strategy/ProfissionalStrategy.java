package br.com.eHealth.strategy;

import br.com.eHealth.model.Profissional;
import br.com.eHealth.model.dto.ProfissionalDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfissionalStrategy {
    Profissional criar(ProfissionalDTO profissionalDTO);
    List<Profissional> listarTodos();
//    Optional<Profissional> buscarPorId(Long id);
//    Profissional atualizarProfissional(Long id, ProfissionalDTO profissionalDTO);
//    void deletarProfissional(Long id);

}
