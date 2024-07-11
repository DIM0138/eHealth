package br.com.eHealth.model.eHealth;

import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class AtividadeDiaria {
    public enum Emocao {
        FELIZ,
        TRISTE,
        NEUTRO,
        ESTRESSADO,
        ANSIOSO,
        PENDENTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private LocalTime horario;

    @Enumerated(EnumType.STRING)
    private Emocao emocao = Emocao.PENDENTE;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "tratamento_id")
    private Tratamento tratamento;

    private Boolean atividadeFeita;

    @Column(nullable = false)
    private LocalDate data;

    public AtividadeDiariaDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        AtividadeDiariaDTO atividadeDiariaDTO = objectMapper.convertValue(this, AtividadeDiariaDTO.class);
        TratamentoDTO tratamentoDTO = this.tratamento.toDTO();
        atividadeDiariaDTO.setTratamento(tratamentoDTO);

        return atividadeDiariaDTO;
    }

}
