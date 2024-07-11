package br.com.eHealth.model.eHealth;

import br.com.eHealth.model.eHealth.dto.AtividadeDiariaDTO;
import br.com.eHealth.model.eHealth.dto.RegistroDiarioDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class RegistroDiario {

    public enum QualidadeSono {
        EXCELENTE,
        BOM,
        REGULAR,
        RUIM,
        PESSIMO,
        PENDENTE
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<AtividadeDiaria> atividasDiarias = new ArrayList<AtividadeDiaria>();

    private LocalDate data;

    @ElementCollection
    @Builder.Default
    private List<String> sintomas = new ArrayList<String>();

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private QualidadeSono qualidadeSono = QualidadeSono.PENDENTE;

    @ElementCollection
    @Builder.Default
    private List<Long> quantidadeAgua = new ArrayList<>();

    public void adicionarAtividadeDiaria(AtividadeDiaria atividadeDiaria){
        this.atividasDiarias.add(atividadeDiaria);
    }

    public void addSintoma(String sintoma) {
        this.sintomas.add(sintoma);
    }

    public void addListaSintomas(List<String> sintomas) {
        this.sintomas.addAll(sintomas);
    }

    public RegistroDiarioDTO toDTO(){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        RegistroDiarioDTO registroDiarioDTO = objectMapper.convertValue(this, RegistroDiarioDTO.class);
        List<AtividadeDiariaDTO> atividadesDiariasDTO = this.getAtividasDiarias()
                .stream()
                .map(AtividadeDiaria::toDTO).collect(Collectors.toList());

        registroDiarioDTO.setAtividadesDiarias(atividadesDiariasDTO);

        return registroDiarioDTO;
    }
}
