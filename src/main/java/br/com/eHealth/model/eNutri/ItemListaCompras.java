package br.com.eHealth.model.eNutri;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Embeddable
@Data
public class ItemListaCompras {
    private String ingrediente;
    private String metrica;
    private int quantidadeTotal;
}
