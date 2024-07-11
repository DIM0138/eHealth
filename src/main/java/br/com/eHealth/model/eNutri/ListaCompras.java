package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.ResumoAtividades;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@Data
@EqualsAndHashCode(callSuper = false)
public class ListaCompras extends ResumoAtividades {
    private List<ItemListaCompras> itens;
}
