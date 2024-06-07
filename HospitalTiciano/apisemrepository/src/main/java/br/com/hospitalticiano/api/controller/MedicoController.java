package br.com.hospitalticiano.api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("medico")
public class MedicoController {

    @GetMapping("/nome")
    @ResponseStatus(HttpStatus.OK)
    public String exibirNome(){
        return "Ticiano Médico";
    }
}
