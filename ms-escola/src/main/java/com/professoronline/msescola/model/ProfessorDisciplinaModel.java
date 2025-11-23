package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "professor_disciplina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProfessorDisciplinaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_professor_disciplina")
    private Integer idProfessorDisciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", nullable = false)
    private Integer professor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina", nullable = false)
    private DisciplinaModel disciplinaModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semestre", nullable = false)
    private SemestreModel semestreModel;

    @Column(name = "prioridade", nullable = false)
    private Integer prioridade;
}