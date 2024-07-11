package br.com.eHealth.model.eHealth.dto;

import br.com.eHealth.model.eHealth.Tratamento;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TratamentoDTO {
    private long id;
    private String nome;
    private String descricao;

    public TratamentoDTO(Tratamento tratamento){
        this.id = tratamento.getId();
        this.nome = tratamento.getNome();
        this.descricao = tratamento.getDescricao();
    }
}
