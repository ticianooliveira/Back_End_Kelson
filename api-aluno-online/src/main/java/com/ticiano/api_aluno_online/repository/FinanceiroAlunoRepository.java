package com.ticiano.api_aluno_online.repository;

import com.ticiano.api_aluno_online.model.FinanceiroAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FinanceiroAlunoRepository extends JpaRepository<FinanceiroAluno, Long>{
}
