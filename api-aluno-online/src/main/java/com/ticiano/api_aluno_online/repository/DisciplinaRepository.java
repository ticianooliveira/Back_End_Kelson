package com.ticiano.api_aluno_online.repository;

import com.ticiano.api_aluno_online.model.Disciplina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisciplinaRepository extends JpaRepository<Disciplina, Long>{
    List<Disciplina> findByProfessorId(Long professorId);
    List<Disciplina> findByName(Long professorId);

}
