package com.ticiano.api_aluno_online.repository;


import com.ticiano.api_aluno_online.model.Fatura;
import com.ticiano.api_aluno_online.model.FinanceiroAluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;

@Repository
public interface FaturaRepository extends JpaRepository<Fatura, Long>{
    boolean existsByStudentFinancialAndDueDate(FinanceiroAluno studentFinancial, LocalDateTime dueDate);
}
