package br.com.eHealth.service.eHealth;

import java.util.List;
import java.util.NoSuchElementException;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.model.eHealth.*;
import br.com.eHealth.repository.eHealth.AtividadeDiariaRepository;
import br.com.eHealth.repository.eHealth.PlanoRepository;
import br.com.eHealth.repository.eHealth.RegistroDiarioRepository;
import br.com.eHealth.repository.eHealth.UsuarioRepository;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.service.eNutri.PacienteService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;

import org.springframework.stereotype.Service;

@Service
public class PlanoService{

    @Autowired
    protected PacienteService pacienteService;

    @Autowired
    protected UsuarioRepository<Profissional> profissionalRepository;

    @Autowired
    protected TratamentoService tratamentoService;

    @Autowired
    protected PlanoRepository planoRepository;

    @Autowired
    protected RegistroDiarioRepository registroDiarioRepository;

    @Autowired
    protected AtividadeDiariaRepository atividadeDiariaRepository;

    @Autowired
    protected PacienteRepository pacienteRepository;


    @Transactional
    public PlanoDTO criarPlano(PlanoDTO planoDTO) {
        Plano novoPlano = new Plano();
        Paciente paciente = pacienteService.buscarPorId(planoDTO.getPaciente());
        Profissional profissional = profissionalRepository.findById(planoDTO.getProfissionalResponsavel()).orElseThrow(() -> new ResourceNotFoundException("Profissional de ID" + planoDTO.getProfissionalResponsavel() + "não encontrado."));

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
            return plano;
        } catch (NoSuchElementException e) {
            throw new ResourceNotFoundException("Plano de ID " + id + " não encontrado.");
        }
    }

    public Plano ativarPlano(Long id) {
        Plano plano = buscarPorId(id);
        long pacienteId = plano.getPaciente().getId();
        Paciente paciente = pacienteService.buscarPorId(pacienteId);

        if (paciente.getPlanoAtual() != null){
            paciente.getPlanoAtual().setAtivo(false);
        }
        paciente.setPlanoAtual(plano);
        plano.setAtivo(true);

        pacienteRepository.save(paciente);
        return planoRepository.save(plano);
    }
    public Boolean deletarPlano(Long id) {
        Plano plano = buscarPorId(id);
        planoRepository.delete(plano);
        return true;
    }

    public AtividadeDiaria criarAtividadeDiaria(AtividadeDiariaDTO atividadeDiariaDTO, Long planoId) {
        Plano plano = buscarPorId(planoId);

        Long registroDiarioId = plano.getRegistroDiarioByDate(atividadeDiariaDTO.getData()).getId();
        RegistroDiario registroDiario = buscarRegistroDiarioPorID(registroDiarioId);
        Tratamento tratamento = tratamentoService.buscarPorId(atividadeDiariaDTO.getTratamento().getId());

        AtividadeDiaria novaAtividadeDiaria = new AtividadeDiaria();
        novaAtividadeDiaria.setData(atividadeDiariaDTO.getData());
        novaAtividadeDiaria.setHorario(atividadeDiariaDTO.getHorario());
        novaAtividadeDiaria.setTratamento(tratamento);

        AtividadeDiaria atividadeDiariaSalva = atividadeDiariaRepository.save(novaAtividadeDiaria);
        registroDiario.adicionarAtividadeDiaria(atividadeDiariaSalva);
        registroDiarioRepository.save(registroDiario);

        return atividadeDiariaSalva;
    }

    public AtividadeDiariaDTO atualizarAtividade(AtividadeDiariaDTO atividadeDTO) {
        return null;
    }

    public Boolean deletarAtividade(Long id) {
        AtividadeDiaria atividadeDiaria = buscarAtividadeDiariaPorId(id);
        atividadeDiariaRepository.delete(atividadeDiaria);
        return true;
    }

    public AtividadeDiaria responderAtividadeDiaria(AtividadeDiariaDTO atividadeDiariaDTO) {
        AtividadeDiaria atividadeDiaria = buscarAtividadeDiariaPorId(atividadeDiariaDTO.getId());
        atividadeDiaria.setEmocao(atividadeDiariaDTO.getEmocao());
        atividadeDiaria.setAtividadeFeita(atividadeDiariaDTO.getAtividadeFeita());

        return atividadeDiariaRepository.save(atividadeDiaria);
    }

    private RegistroDiario buscarRegistroDiarioPorID(Long id){
        return registroDiarioRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Registro diário não existe"));
    }

    private AtividadeDiaria buscarAtividadeDiariaPorId(Long id){
        return atividadeDiariaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Atividade diária não existe"));
    }

    public RegistroDiario responderRegistroDiario(RegistroDiarioDTO registroDiarioDTO) {
        RegistroDiario registroDiario = buscarRegistroDiarioPorID(registroDiarioDTO.getId());
        registroDiario.addListaSintomas(registroDiarioDTO.getSintomas());
        if (registroDiarioDTO.getQualidadeSono() != null){
            registroDiario.setQualidadeSono(registroDiarioDTO.getQualidadeSono());
        }
        if (registroDiarioDTO.getQuantidadeAgua() != null){
            List<Long> quantidadeAguaNova = registroDiarioDTO.getQuantidadeAgua();
            registroDiario.getQuantidadeAgua().addAll(quantidadeAguaNova);
        }

        return registroDiarioRepository.save(registroDiario);
    }

    public List<PlanoDTO> buscarPlanosPorProfissionalId(Long id) {
        Profissional profissional = profissionalRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Profissional de ID" + id + "não encontrado."));
        List<Plano> planos = planoRepository.getByProfissionalResponsavel(profissional);
        List<PlanoDTO> planosDTO = planos.stream().map(Plano::toDTO).toList();
        return planosDTO;
    }
}
