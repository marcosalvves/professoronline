package com.professoronline.msescola.dto;

import com.professoronline.msescola.model.ProfessorDisciplinaModel;

public record ProfessorDisciplinaNomesDTO(
        String nomeProfessor,
        String nomeDisciplina,
        Integer prioridade,
        String semestre
) {
    public ProfessorDisciplinaNomesDTO(ProfessorDisciplinaModel professorDisciplina){
        this(
                professorDisciplina.getIdProfessorDisciplina().toString(),
                professorDisciplina.getDisciplinaModel().getDescricao(),
                professorDisciplina.getPrioridade(),
                professorDisciplina.getSemestreModel().getPeriodoAno()
        );
    }
}
