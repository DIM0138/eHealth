package br.com.eHealth.model.eEndo;

import br.com.eHealth.model.eHealth.ResumoAtividades;
import lombok.Data;

import java.util.List;

@Data
public class ResumoPrescricoes extends ResumoAtividades {
    List<ItemResumo> itemResumo;
}
