package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.Tratamento;
import br.com.eHealth.model.eHealth.dto.UsuarioDTO;
import br.com.eHealth.model.eNutri.dto.ReceitaDTO;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
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
