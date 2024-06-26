package br.com.eHealth.service;

import br.com.eHealth.model.Profissional;
import br.com.eHealth.model.dto.ProfissionalDTO;
import br.com.eHealth.strategy.ProfissionalStrategy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfissionalService {
    private ProfissionalStrategy profissionalStrategy;

    public ProfissionalService(ProfissionalStrategy profissionalStrategy) {
        this.profissionalStrategy = profissionalStrategy;
    }

    public Profissional criarProfissional(ProfissionalDTO profissionalDTO){
        return profissionalStrategy.criar(profissionalDTO);
    }

    public List<Profissional> listarTodos() {
        return profissionalStrategy.listarTodos();
    }
}
