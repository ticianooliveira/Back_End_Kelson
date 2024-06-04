package com.ticiano.api_aluno_online.service;

import com.ticiano.api_aluno_online.model.Professor;
import com.ticiano.api_aluno_online.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {
    @Autowired
    ProfessorRepository professorRepository;

    public void create(Professor professor) {
        professorRepository.save(professor);
    }
}
