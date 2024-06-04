package com.ticiano.api_aluno_online.controller;

import com.ticiano.api_aluno_online.dtos.AtualizarNotasRequest;
import com.ticiano.api_aluno_online.dtos.HistoricoAlunoResponse;
import com.ticiano.api_aluno_online.model.MatriculaAluno;
import com.ticiano.api_aluno_online.service.MatriculaAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/matricula-aluno")
public class MatriculaAlunoController {

    @Autowired
    MatriculaAlunoService matriculaAlunoService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MatriculaAluno matriculaAluno) {
        matriculaAlunoService.create(matriculaAluno);
    }

    @PatchMapping("/update-grades/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateGrades(@RequestBody AtualizarNotasRequest atualizarNotasRequest,
                             @PathVariable Long matriculaAlunoId) {
        matriculaAlunoService.updateGrades(matriculaAlunoId, atualizarNotasRequest);
    }

    @PatchMapping("/update-status-to-break/{matriculaAlunoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateStatusToBreak(@PathVariable Long matriculaAlunoId) {
        matriculaAlunoService.updateStatusToBreak(matriculaAlunoId);
    }

    @GetMapping("/academic-transcript/{alunoId}")
    @ResponseStatus(HttpStatus.OK)
    public HistoricoAlunoResponse getAcademicTranscript(@PathVariable Long alunoId) {
        return matriculaAlunoService.getAcademicTranscript(alunoId);
    }
}
