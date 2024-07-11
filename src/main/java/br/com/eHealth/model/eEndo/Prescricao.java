package br.com.eHealth.model.eEndo;

import br.com.eHealth.model.eEndo.dto.PrescricaoDTO;
import br.com.eHealth.model.eHealth.Tratamento;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class Prescricao extends Tratamento {

    @Column(nullable = false)
    private double dosagem;

    private String efeitosColaterais;

    @Column(nullable = false)
    private String instrucoes;

    @Override
    public PrescricaoDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, PrescricaoDTO.class);
    }
}
