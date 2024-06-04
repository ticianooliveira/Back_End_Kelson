package com.ticiano.api_aluno_online.service;

import com.ticiano.api_aluno_online.dtos.CriarAlunoRequest;
import com.ticiano.api_aluno_online.enums.FinanceiroStatusEnum;
import com.ticiano.api_aluno_online.model.Aluno;
import com.ticiano.api_aluno_online.model.Curso;
import com.ticiano.api_aluno_online.model.FinanceiroAluno;
import com.ticiano.api_aluno_online.repository.AlunoRepository;
import com.ticiano.api_aluno_online.repository.CursoRepository;
import com.ticiano.api_aluno_online.repository.FinanceiroAlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    FinanceiroAlunoRepository financeiroAlunoRepository;

    @Autowired
    CursoRepository cursoRepository;

    public void create(CriarAlunoRequest criarAlunoRequest) {
        Curso curso = cursoRepository.findById(criarAlunoRequest.getCourseId())
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND, "Curso não encontrado"));

        Aluno alunoSaved = alunoRepository.save(
                new Aluno(
                        null,
                        criarAlunoRequest.getName(),
                        criarAlunoRequest.getEmail(),
                        criarAlunoRequest.getCpf(),
                        criarAlunoRequest.getMatricula(),
                        curso
                )
        );

        createFinanceiroInformation(alunoSaved, criarAlunoRequest);
    }

    public List<Aluno> findAll() {
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findById(Long id) {
        return alunoRepository.findById(id);
    }

    public void update(Long id, Aluno aluno) {
        Optional<Aluno> alunoFromDb = findById(id);

        if (alunoFromDb.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aluno não encontrado no banco de dados");
        }

        Aluno alunoUpdated = alunoFromDb.get();

        alunoUpdated.setName(aluno.getName());
        alunoUpdated.setEmail(aluno.getEmail());
        alunoUpdated.setCpf(aluno.getCpf());
        alunoUpdated.setMatricula(aluno.getMatricula());

        alunoRepository.save(alunoUpdated);
    }

    public void deleteById(Long id) {
        alunoRepository.deleteById(id);
    }

    public void createFinanceiroInformation(Aluno aluno, CriarAlunoRequest criarAlunoRequest) {
        FinanceiroAluno financeiroAluno = new FinanceiroAluno(
                null,
                aluno,
                criarAlunoRequest.getDiscount(),
                criarAlunoRequest.getDueDate(),
                FinanceiroStatusEnum.EM_DIA
        );

        financeiroAlunoRepository.save(financeiroAluno);
    }
}
