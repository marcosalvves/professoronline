package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "disciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisciplinaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disciplina")
    private Integer id;

    @Column(name = "sigla", nullable = false, length = 10)
    private String sigla;

    @Column(name = "descricao", nullable = false, length = 255)
    private String descricao;

    @Column(name = "carga_horaria", nullable = false)
    private Integer carga_horaria;

    @Column(name = "status", nullable = false)
    private Boolean status;

}