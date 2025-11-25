package com.professoronline.msprofessor.dto;

import com.professoronline.msprofessor.model.Professor;

public record ProfessorDTO(
        Integer id,
    Integer idUsuario,
    Integer idEscola,
    String registroProfessor,
    Boolean statusProfessor,
    String nomeUsuario,
    String nomeEscola
){
    public ProfessorDTO(Professor professor) {
        this(
                professor.getIdProfessor(),
                professor.getIdUsuario().getId(),
                professor.getIdEscola().getId(),
                professor.getRegistroProfessor(),
                professor.getStatusProfessor(),
                professor.getIdUsuario().getNome(),
                professor.getIdEscola().getNome()
        );
    }


}
