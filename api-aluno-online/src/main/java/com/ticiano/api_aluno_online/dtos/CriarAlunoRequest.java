package com.ticiano.api_aluno_online.dtos;

import lombok.Data;

@Data
public class CriarAlunoRequest {
    private String name;
    private String email;
    private String cpf;
    private String matricula;
    private Long courseId;
    private Double discount;
    private Integer dueDate;
}
