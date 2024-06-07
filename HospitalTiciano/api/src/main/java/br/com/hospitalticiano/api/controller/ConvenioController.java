package br.com.hospitalticiano.api.controller;

import br.com.hospitalticiano.api.model.Consulta;
import br.com.hospitalticiano.api.model.Convenio;
import br.com.hospitalticiano.api.service.ConvenioService;
import br.com.hospitalticiano.api.service.MedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/convenio")
public class ConvenioController {

    @Autowired
    ConvenioService convenioService;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void creat(@RequestBody Convenio convenio) {
        convenioService.creat(convenio);
    }
    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<Convenio> findAll(){
        return convenioService.findAll();
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Convenio> findById(@PathVariable Long id){
        return convenioService.findById(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody Convenio convenio, @PathVariable Long id) {
        convenioService.update(id, convenio);
    }
}


