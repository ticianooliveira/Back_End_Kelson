package com.ticiano.api_aluno_online.service;

import com.ticiano.api_aluno_online.model.Disciplina;
import com.ticiano.api_aluno_online.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DisciplinaService {
    @Autowired
    DisciplinaRepository disciplinaRepository;

    public void create(Disciplina disciplina) {
        disciplinaRepository.save(disciplina);
    }

    public List<Disciplina> findByProfessorId(Long professorId) {
        return disciplinaRepository.findByProfessorId(professorId);
    }
}
