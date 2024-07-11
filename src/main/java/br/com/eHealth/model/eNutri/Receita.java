package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@ToString
@Inheritance(strategy = InheritanceType.JOINED)
public class Receita extends Tratamento {
    public enum TipoRefeicao {
        CAFE,
        ALMOCO,
        JANTAR,
        LANCHE,
        OUTRO
    }

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoRefeicao tipoRefeicao;

    @Column(nullable = false)
    private int tempoPreparo;

    @Column(nullable = false)
    private int calorias;
    
    @Column(name = "imagem_url")
    private String imagemURL;

    @Column(nullable = false)
    @ElementCollection
    private List<String> modoPreparo;

    @CollectionTable(name = "ingredientes_receita")
    @OneToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<IngredienteReceita> ingredientes;

    @Column(nullable = false)
    private Boolean contemAlergicos;

    @ElementCollection
    private List<String> alergicos;

    @Override
    public ReceitaDTO toDTO() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();

        return objectMapper.convertValue(this, ReceitaDTO.class);
    }
}
