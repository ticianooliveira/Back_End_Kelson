package br.com.hospitalticiano.api.controller;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Paciente;
import br.com.hospitalticiano.api.service.MedicoService;
import br.com.hospitalticiano.api.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    PacienteService pacienteService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creat(@RequestBody Paciente paciente) {
        pacienteService.creat(paciente);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Paciente> findAll(){
        return pacienteService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Paciente> findById(@PathVariable Long id){
        return pacienteService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Paciente paciente, @PathVariable Long id) {
        pacienteService.update(id, paciente);
    }
}


