package br.com.eHealth.model.eFit.dto;

import br.com.eHealth.model.eFit.Instrutor;
import br.com.eHealth.model.eHealth.dto.ProfissionalDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class InstrutorDTO extends ProfissionalDTO {
    
    private Optional<String> CREF;
    
    private Optional<List<String>> certificacoes;

    public InstrutorDTO(Instrutor instrutor) {
        super(instrutor);
        this.CREF = Optional.ofNullable(instrutor.getCREF());
        this.certificacoes = Optional.ofNullable(instrutor.getCertificacoes());
    }
}
