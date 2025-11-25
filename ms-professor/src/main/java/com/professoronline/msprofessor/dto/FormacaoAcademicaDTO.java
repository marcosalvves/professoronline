package com.professoronline.msprofessor.dto;

public record FormacaoAcademicaDTO(
        Integer idFormacao,
        Integer idProfessor, // Mantido para referência, mas virá do token/path
        Integer idTipoCategoria,
        String nomeCurso,
        String nomeInstituicaoFormacao,
        Integer anoConclusao
) {
    // É necessária a criação de um construtor de mapeamento a partir do modelo FormacaoAcademica.java local
    // public FormacaoAcademicaDTO(FormacaoAcademica formacaoAcademica) { ... }
}