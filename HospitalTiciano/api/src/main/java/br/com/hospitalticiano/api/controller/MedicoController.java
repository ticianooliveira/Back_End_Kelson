package br.com.hospitalticiano.api.controller;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Medico;
import br.com.hospitalticiano.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    MedicoService medicoService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creat(@RequestBody Medico medico) {
        medicoService.creat(medico);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Medico> findAll(){
        return medicoService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Medico> findById(@PathVariable Long id){
        return medicoService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Medico medico, @PathVariable Long id) {
        medicoService.update(id, medico);
    }
}


