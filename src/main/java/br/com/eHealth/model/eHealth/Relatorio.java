package br.com.eHealth.model.eHealth;

import com.fasterxml.jackson.annotation.JsonProperty;
import br.com.eHealth.model.eHealth.dto.RelatorioDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Relatorio {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    @JsonProperty("paciente")
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "profissional_id")
    @JsonProperty("profissional_responsavel")
    private Profissional profissionalResponsavel;

    @Column(nullable = false)
    @JsonProperty("data_consulta")
    private LocalDate dataConsulta;

    @CollectionTable(name = "relatorio_medicoes")
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonProperty("medicoes")
    private List<MedicaoRelatorio> medicoes;

    public Relatorio() {
        this.medicoes = new ArrayList<MedicaoRelatorio>();
    }

    public RelatorioDTO toDTO() {
        RelatorioDTO relatorioDTO = new RelatorioDTO();
        relatorioDTO.setId(Optional.ofNullable(this.id));
        relatorioDTO.setPaciente(Optional.ofNullable(this.paciente.getId()));
        relatorioDTO.setProfissionalResponsavel(Optional.ofNullable(this.profissionalResponsavel.getId()));
        relatorioDTO.setDataConsulta(Optional.ofNullable(this.dataConsulta));
        relatorioDTO.setMedicoes(Optional.ofNullable(this.medicoes));

        return relatorioDTO;
    }
}