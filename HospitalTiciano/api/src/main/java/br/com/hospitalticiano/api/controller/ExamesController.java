package br.com.hospitalticiano.api.controller;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Exames;
import br.com.hospitalticiano.api.service.ExamesService;
import br.com.hospitalticiano.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/exames")
public class ExamesController {

    @Autowired
    ExamesService examesService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creat(@RequestBody Exames exames) {
        examesService.creat(exames);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Exames> findAll(){
        return examesService.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Exames> findById(@PathVariable Long id){
        return examesService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Exames exames, @PathVariable Long id) {
        examesService.update(id, exames);
    }
}


