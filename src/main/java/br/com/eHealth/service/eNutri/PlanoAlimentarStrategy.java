package br.com.eHealth.service.eNutri;

import java.util.List;

import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.dto.AtividadeDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;
import br.com.eHealth.service.eHealth.PlanoStrategy;

@Component
public class PlanoAlimentarStrategy extends PlanoStrategy<PlanoDTO, RegistroDiarioDTO, AtividadeDTO> {

    @Override
    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarPlano'");
    }

    @Override
    public PlanoDTO ativarPlano(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'ativarPlano'");
    }

    @Override
    public Boolean deletarPlano(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarPlano'");
    }

    @Override
    public AtividadeDTO criarAtividade(AtividadeDTO atividadeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'criarAtividade'");
    }

    @Override
    public AtividadeDTO atualizarAtividade(AtividadeDTO atividadeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizarAtividade'");
    }

    @Override
    public Boolean deletarAtividade(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletarAtividade'");
    }

    @Override
    public AtividadeDTO responderAtividade(AtividadeDTO atividadeDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'responderAtividade'");
    }

    @Override
    public RegistroDiarioDTO responderRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'responderRegistroDiario'");
    }

    @Override
    public List<PlanoDTO> buscarPlanosPorProfissionalId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPlanosPorProfissionalId'");
    }

    @Override
    public ResumoAtividadesDTO gerarResumoAtividades(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'gerarResumoAtividades'");
    }
     
}
