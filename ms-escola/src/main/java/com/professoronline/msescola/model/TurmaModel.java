package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "turma")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TurmaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Integer vagas;

    @Column(nullable = false)
    private String codigo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_disciplina")
    private DisciplinaModel disciplina;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semestre")
    private SemestreModel semestre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario_padrao")
    private HorarioPadraoModel horarioPadrao;

    @Column(name = "id_professor", nullable = false)
    private Integer professor;

}
