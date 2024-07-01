/*
 * NOTE(Amanda): Essa parte deve ser implementada nas variações do framework.
 * */
package br.com.eHealth.controller.eNutri;

import br.com.eHealth.controller.eHealth.IProfissionalController;
import br.com.eHealth.model.eNutri.dto.NutricionistaDTO;
import br.com.eHealth.model.eNutri.dto.PacienteDTO;
import br.com.eHealth.service.eNutri.NutricionistaService;
import br.com.eHealth.service.eNutri.NutricionistaStrategy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController implements IProfissionalController<NutricionistaDTO> {

    private final NutricionistaService nutricionistaService;

    public NutricionistaController(@Autowired NutricionistaStrategy nutricionistaStrategy) {
        this.nutricionistaService = new NutricionistaService(nutricionistaStrategy);
    }

    @Override
    @PostMapping
    public NutricionistaDTO criar(@RequestBody NutricionistaDTO nutricionistaDTO) {

        return this.nutricionistaService.criar(nutricionistaDTO);
    }

    @Override
    @PatchMapping("/{id}")
    public NutricionistaDTO atualizar(@RequestBody NutricionistaDTO nutricionistaDTO, @PathVariable Long id) {
        return this.nutricionistaService.atualizar(nutricionistaDTO, id);
    }

    @Override
    @DeleteMapping("/{id}")
    public Boolean deletar(@PathVariable Long id) {
        return this.nutricionistaService.deletar(id);
    }

    @Override
    @GetMapping("/{id}")
    public NutricionistaDTO buscarPorId(@PathVariable Long id) {
        return this.nutricionistaService.buscarPorId(id);
    }

    @Override
    @GetMapping("/buscar/todos")
    public List<NutricionistaDTO> buscarTodos() {
        return this.nutricionistaService.buscarTodos();
    }

    @Override
    @GetMapping("/login")
    public Boolean login(@RequestParam("login") String login, @RequestParam("senha") String senha) {
        return this.nutricionistaService.login(login, senha);
    }

    @Override
    @GetMapping("/existe")
    public Boolean existe(@RequestParam(value = "id", required = false) Long id,
                                   @RequestParam(value = "cpf", required = false) String cpf,
                                   @RequestParam(value = "login", required = false) String login,
                                   @RequestParam(value = "email", required = false) String email) {

        return this.nutricionistaService.existe(id, cpf, login, email);
    }

    @GetMapping("/existe-nutricionista/{crn}")
    public Boolean existeCrn(@PathVariable String crn) {
        return this.nutricionistaService.existeCrn(crn);
    }

    @GetMapping("/{id}/pacientes")
    public List<PacienteDTO> buscarPacientesPorProfissionalId(Long id) {

        return this.nutricionistaService.buscarPacientesPorProfissionalId(id);
    }
}
