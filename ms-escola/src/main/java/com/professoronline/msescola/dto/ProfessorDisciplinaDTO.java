package com.professoronline.msescola.dto;

import com.professoronline.msescola.model.ProfessorDisciplinaModel;

public record ProfessorDisciplinaDTO(
        Integer idProfessor,
        Integer idDisciplina,
        Integer idSemestre,
        Integer prioridade
) {
    public ProfessorDisciplinaDTO(ProfessorDisciplinaModel professorDisciplina){
        this(
                professorDisciplina.getProfessor(),
                professorDisciplina.getDisciplinaModel().getId(),
                professorDisciplina.getSemestreModel().getId(),
                professorDisciplina.getPrioridade()
        );
    }
}
