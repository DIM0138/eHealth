package br.com.eHealth.service.eNutri;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.exception.ResourceNotFoundException;
import br.com.eHealth.exception.ValidationException;
import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.service.eHealth.ProfissionalStrategy;

@Component
public class NutricionistaStrategy extends ProfissionalStrategy<NutricionistaDTO> {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    public PacienteRepository pacienteRepository;

    @Override
    public NutricionistaDTO criar(NutricionistaDTO nutricionistaDTO) {

        if(existe(nutricionistaDTO.getId(), nutricionistaDTO.getCpf(), nutricionistaDTO.getLogin(), nutricionistaDTO.getEmail())) {
            throw new ValidationException("Nutricionista ja cadastrado.");
        }

        Nutricionista novoNutricionista = Nutricionista.builder()
                                                       .nomeCompleto(nutricionistaDTO.getNomeCompleto())
                                                       .genero(nutricionistaDTO.getGenero())
                                                       .dataNascimento(nutricionistaDTO.getDataNascimento())
                                                       .endereco(nutricionistaDTO.getEndereco())
                                                       .telefone(nutricionistaDTO.getTelefone())
                                                       .email(nutricionistaDTO.getEmail())
                                                       .CPF(nutricionistaDTO.getCpf())
                                                       .CRN(nutricionistaDTO.getCRN())
                                                       .login(nutricionistaDTO.getLogin())
                                                       .senha(nutricionistaDTO.getSenha())
                                                       .build();
        
        Nutricionista nutricionistaSalvo = nutricionistaRepository.save(novoNutricionista);

        return new NutricionistaDTO(nutricionistaSalvo);
    }

    @Override
    public NutricionistaDTO atualizar(NutricionistaDTO usuarioDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Boolean deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public NutricionistaDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<NutricionistaDTO> buscarTodos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarTodos'");
    }

    @Override
    public Boolean login(String login, String senha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

    @Override
    public Boolean existe(Long id, String cpf, String login, String email) {
        if(id != null && nutricionistaRepository.existsById(id) ||
           cpf != null && nutricionistaRepository.existsByCPF(cpf) || 
           login != null && nutricionistaRepository.existsByLogin(login) || 
           email != null && nutricionistaRepository.existsByEmail(email)) {

            return true;
        }
        
        return false;
    }

    public Boolean existeCrn(String crn) {
        return this.nutricionistaRepository.existsByCRN(crn);
    }

    @Override
    public List<PacienteDTO> buscarPacientesPorProfissionalId(Long id) {

        List<Paciente> pacientes = pacienteRepository.findByProfissionalResponsavelId(id);

        List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>(); 

        for(Paciente paciente : pacientes) {
            pacientesDTO.add(new PacienteDTO(paciente));
        }

        return pacientesDTO;
    }

}
