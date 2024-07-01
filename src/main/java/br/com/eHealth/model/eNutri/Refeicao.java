package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.Tratamento;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;

import java.util.List;

public class Refeicao extends Tratamento {
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
}
