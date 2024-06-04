package com.ticiano.api_aluno_online.controller;

import com.ticiano.api_aluno_online.model.Professor;
import com.ticiano.api_aluno_online.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/professor")
public class ProfessorController {
    @Autowired
    ProfessorService professorService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Professor professor) {
        professorService.create(professor);
    }
}
