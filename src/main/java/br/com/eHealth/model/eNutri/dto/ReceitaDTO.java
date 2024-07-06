package br.com.eHealth.model.eNutri.dto;

import br.com.eHealth.model.eHealth.dto.TratamentoDTO;
import br.com.eHealth.model.eNutri.IngredienteReceita;
import br.com.eHealth.model.eNutri.Nutricionista;
import br.com.eHealth.model.eNutri.Receita;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReceitaDTO extends TratamentoDTO {
    private Receita.TipoRefeicao tipoRefeicao;
    private int tempoPreparo;
    private int calorias;
    private String imagemURL;
    private List<String> modoPreparo;
    private List<IngredienteReceita> ingredientes;
    private Boolean contemAlergicos;
    private List<String> alergicos;

    public ReceitaDTO(Receita receita) {
        super(receita);
        this.tipoRefeicao = receita.getTipoRefeicao();
        this.tempoPreparo = receita.getTempoPreparo();
        this.calorias = receita.getCalorias();
        this.imagemURL = receita.getImagemURL();
        this.modoPreparo = receita.getModoPreparo();
        this.ingredientes = receita.getIngredientes();
        this.contemAlergicos = receita.getContemAlergicos();
        this.alergicos = receita.getAlergicos();
    }
}
