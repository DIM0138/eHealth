package br.com.eHealth.model.eNutri;

import br.com.eHealth.model.eHealth.ResumoAtividades;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;
import java.util.List;

@Data
public class ListaCompras extends ResumoAtividades {
    private List<ItemListaCompras> itens;
}
