package br.com.eHealth.model.eNutri.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

import br.com.eHealth.model.eHealth.Plano;
import br.com.eHealth.model.eHealth.RegistroDiario;
import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.PlanoDTO;
import br.com.eHealth.model.eHealth.factory.PlanoFactory;
import br.com.eHealth.model.eNutri.RegistroDiarioRefeicao;
import br.com.eHealth.repository.PlanoRepository;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.repository.eNutri.RegistroDiarioRefeicaoRepository;
import jakarta.transaction.Transactional;

@Component
public class PlanoAlimentarFactory implements PlanoFactory {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private RegistroDiarioRefeicaoRepository registroDiarioRefeicaoRepository;
    
    @Override
    @Transactional
    public Plano criarPlano(PlanoDTO planoDTO) {
        Plano novoPlano = Plano.builder()
                               .dataInicio(planoDTO.getDataInicio())
                               .dataFim(planoDTO.getDataFim())
                               .paciente(pacienteRepository.findById(planoDTO.getPaciente().getId().orElseThrow()).orElseThrow())
                               .profissional(nutricionistaRepository.findById(planoDTO.getProfissionalResponsavel()).get())
                               .registrosDiarios(new ArrayList<RegistroDiario>())
                               .build();

        Plano planoSalvo = planoRepository.save(novoPlano);

        int diasDePlano = planoDTO.getDataFim().getDayOfYear() - planoDTO.getDataInicio().getDayOfYear() + 1;

        for(int i = 0; i < diasDePlano; i++) {
            RegistroDiarioRefeicao registroDiario = RegistroDiarioRefeicao.builder()
                                                                  .data(planoDTO.getDataInicio().plusDays(i))
                                                                  .plano(planoSalvo)
                                                                  .sintomas(new ArrayList<String>())
                                                                  .tratamentos(new ArrayList<Tratamento>())
                                                                  .build();

            RegistroDiarioRefeicao registroDiarioSalvo = registroDiarioRefeicaoRepository.save(registroDiario);

            novoPlano.addRegistroDiario(registroDiarioSalvo);
        }

        return novoPlano;
    }
}
