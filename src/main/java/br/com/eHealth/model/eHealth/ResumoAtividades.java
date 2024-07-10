package br.com.eHealth.model.eHealth;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
public abstract class ResumoAtividades {
    
    @CreationTimestamp
    private Instant dataCriacao;
}
