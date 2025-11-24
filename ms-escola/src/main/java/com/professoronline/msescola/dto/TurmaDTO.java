package com.professoronline.msescola.dto;

import com.professoronline.msescola.model.TurmaModel;

public record TurmaDTO(
        Integer professorId,
        Integer disciplinaId,
        Integer semestreId,
        Integer horarioPadraoId,
        Integer vagas,
        String codigo,
        String nomeDisciplina,
        String anoSemestre
) {
    public TurmaDTO(TurmaModel turma) {
        this(
                turma.getProfessor(),
                turma.getDisciplina().getId(),
                turma.getSemestre().getId(),
                turma.getHorarioPadrao().getId(),
                turma.getVagas(),
                turma.getCodigo(),
                turma.getDisciplina().getDescricao(),
                turma.getSemestre().getPeriodoAno()
        );
    }
}
