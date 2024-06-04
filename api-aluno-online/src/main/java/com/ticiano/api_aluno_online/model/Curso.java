package com.ticiano.api_aluno_online.model;

import com.ticiano.api_aluno_online.enums.CursoTypeEnum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Curso implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    //Tipo tecnologia / exatas / humanas / saude
    private String categoria;

    @Enumerated(EnumType.STRING)
    private CursoTypeEnum type;

    private BigDecimal monthlyCost;

}
