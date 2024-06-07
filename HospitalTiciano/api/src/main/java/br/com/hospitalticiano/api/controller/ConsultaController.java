package br.com.hospitalticiano.api.controller;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.service.ConsultaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    ConsultaService consultaService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creat(@RequestBody Consulta consulta) {
        consultaService.creat(consulta);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Consulta> findAll(){
        return consultaService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Consulta> findById(@PathVariable Long id){
        return consultaService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Consulta consulta, @PathVariable Long id) {
        consultaService.update(id, consulta);
    }
}


