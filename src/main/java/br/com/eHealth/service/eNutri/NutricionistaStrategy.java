package br.com.eHealth.service.eNutri;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.eHealth.model.eHealth.Paciente;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.repository.eNutri.NutricionistaRepository;
import br.com.eHealth.repository.eNutri.PacienteRepository;
import br.com.eHealth.service.eHealth.ProfissionalStrategy;

@Component
public class NutricionistaStrategy extends ProfissionalStrategy {

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    public PacienteRepository pacienteRepository;

    @Override
    public UsuarioDTO criar(UsuarioDTO usuarioDTO) {

        NutricionistaDTO nutricionistaDTO = (NutricionistaDTO) usuarioDTO;
        Nutricionista novoNutricionista = new Nutricionista();

        if(existe(nutricionistaDTO.getId(), nutricionistaDTO.getCpf(), nutricionistaDTO.getLogin(), nutricionistaDTO.getEmail())) {
            return null;
        }

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
        
        Nutricionista nutricionistaSalvo = nutricionistaRepository.save(novoNutricionista);

        return new NutricionistaDTO(nutricionistaSalvo);
    }

    @Override
    public UsuarioDTO atualizar(UsuarioDTO usuarioDTO, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'atualizar'");
    }

    @Override
    public Boolean deletar(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deletar'");
    }

    @Override
    public UsuarioDTO buscarPorId(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPorId'");
    }

    @Override
    public List<UsuarioDTO> buscarTodos() {
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

    @Override
    public List<PacienteDTO> buscarPacientesPorProfissional(Long id) {

        List<Paciente> pacientes = pacienteRepository.findByProfissionalResponsavelId(id);

        List<PacienteDTO> pacientesDTO = new ArrayList<PacienteDTO>(); 

        for(Paciente paciente : pacientes) {
            pacientesDTO.add(new PacienteDTO(paciente));
        }

        return pacientesDTO;
    }

}
