package com.professoronline.msprofessor.dto;

import com.professoronline.msprofessor.model.FormacaoAcademica;

public record FormacaoAcademicaDTO(
        Integer idFormacao,
        Integer idProfessor,
        Integer idTipoCategoria,
        String nomeCurso,
        String nomeInstituicaoFormacao,
        Integer anoConclusao
) {
    public FormacaoAcademicaDTO(FormacaoAcademica formacaoAcademica) {
        this(
                formacaoAcademica.getIdFormacaoAcademica(),
                formacaoAcademica.getIdProfessor().getIdProfessor(),
                formacaoAcademica.getIdTipoCategoria().getId(),
                formacaoAcademica.getNomeCurso(),
                formacaoAcademica.getNomeInstituicaoFormacao(),
                formacaoAcademica.getAnoConclusao()
        );
    }
}