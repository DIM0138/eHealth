package br.com.eHealth.controller.eHealth;

import br.com.eHealth.model.eHealth.metricas.Metrica;

import br.com.eHealth.service.eHealth.MetricaServiceTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/metricas")
public class MetricasController {

    @Autowired
    MetricaServiceTemplate metricasService;

    @GetMapping("/{idPaciente}")
    public ResponseEntity<Metrica> metricas(
            @PathVariable Long idPaciente,
            @RequestParam(value = "inicio", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate inicio,
            @RequestParam(value = "fim", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate fim
    ){
        Metrica metricas = metricasService.getPacienteMetricas(idPaciente, inicio, fim);
        return ResponseEntity.status(HttpStatus.OK).body(metricas);
    }
}
