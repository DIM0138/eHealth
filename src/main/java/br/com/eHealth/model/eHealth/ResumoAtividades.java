package br.com.eHealth.model.eHealth;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@Data
public abstract class ResumoAtividades {
    @CreationTimestamp
    private Instant dataCriacao;
}
