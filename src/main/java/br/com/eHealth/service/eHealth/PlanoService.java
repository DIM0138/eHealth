package br.com.eHealth.service.eHealth;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.Profissional;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.repository.eHealth.PlanoRepository;
import br.com.eHealth.repository.eHealth.RegistroDiarioRepository;
import br.com.eHealth.service.eNutri.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.ResumoAtividadesDTO;
import org.springframework.stereotype.Service;

@Service
public class PlanoService{
    // protected PlanoStrategy<P, R, A> planoStrategy;

    @Autowired
    protected PacienteService pacienteService;

    @Autowired
    protected UsuarioService usuarioService;

    @Autowired
    protected PlanoRepository planoRepository;

    @Autowired
    protected RegistroDiarioRepository registroDiarioRepository;

    @Transactional
    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        Plano novoPlano = new Plano();
        Paciente paciente = pacienteService.buscarPorId(planoDTO.getPaciente());
        Profissional profissional = (Profissional) usuarioService.buscarPorId(planoDTO.getProfissionalResponsavel());

        novoPlano.setPaciente(paciente);
        novoPlano.setProfissionalResponsavel(profissional);
        novoPlano.setDataInicio(planoDTO.getDataInicio());
        novoPlano.setDataFim(planoDTO.getDataFim());

        Plano planoSalvo = planoRepository.save(novoPlano);

        int diasPlano = planoDTO.getDataFim().getDayOfYear() - planoDTO.getDataInicio().getDayOfYear() + 1;
        for(int i=0; i< diasPlano; i++){
            RegistroDiario novoRegistroDiario = new RegistroDiario();
            novoRegistroDiario.setPlano(planoSalvo);
            novoRegistroDiario.setData(planoDTO.getDataInicio().plusDays(i));
            RegistroDiario registroDiarioSalvo = registroDiarioRepository.save(novoRegistroDiario);
            planoSalvo.addRegistroDiario(registroDiarioSalvo);
        }

        return planoSalvo.toDTO();
    }

    public Plano buscarPorId(Long id) {
        try {
            Plano plano = planoRepository.findById(id).get();
            System.out.println(plano.getRegistrosDiarios());
            return plano;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Plano não encontrado");
        }
    }

    public PlanoDTO ativarPlano(Long id) {
        return null;
    }
    public Boolean deletarPlano(Long id) {
        return null;
    }

    public AtividadeDiariaDTO criarAtividade(AtividadeDiariaDTO atividadeDTO) {
        return null;
    }

    public AtividadeDiariaDTO atualizarAtividade(AtividadeDiariaDTO atividadeDTO) {
        return null;
    }

    public Boolean deletarAtividade(Long id) {
        return null;
    }

    public AtividadeDiariaDTO responderAtividade(AtividadeDiariaDTO atividadeDTO) {
        return null;
    }

    public RegistroDiarioDTO responderRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        return null;
    }

    public List<PlanoDTO> buscarPlanosPorProfissionalId(Long id) {
        return null;
    }

    public ResumoAtividadesDTO gerarResumoAtividades(Long id) {
        return null;
    }


}
