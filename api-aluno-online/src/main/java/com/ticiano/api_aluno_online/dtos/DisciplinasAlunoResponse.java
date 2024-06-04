package com.ticiano.api_aluno_online.dtos;

import com.ticiano.api_aluno_online.enums.MatriculaAlunoStatusEnum;
import lombok.Data;

@Data
public class DisciplinasAlunoResponse {
    private String subjectName;
    private String professorName;
    private Double grade1;
    private Double grade2;
    private Double average;
    private MatriculaAlunoStatusEnum status;
}
