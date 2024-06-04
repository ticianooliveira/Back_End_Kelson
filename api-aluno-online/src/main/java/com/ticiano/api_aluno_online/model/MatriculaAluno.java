package com.ticiano.api_aluno_online.model;

import com.ticiano.api_aluno_online.enums.MatriculaAlunoStatusEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "matricula_aluno")
public class MatriculaAluno implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double grade1;

    private Double grade2;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Aluno student;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Disciplina subject;

    @Enumerated(EnumType.STRING)
    private MatriculaAlunoStatusEnum status;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
