package com.professoronline.msescola.dto;

public record TurmaResponseDTO(Integer professorId,
                               Integer disciplinaId,
                               Integer semestreId,
                               Integer horarioPadraoId,
                               Integer vagas,
                               String codigo,
                               String nomeDisciplina,
                               String anoSemestre,
                               String nomeProfessor,
                               HorarioPadraoDTO horarioPadraoDTO) {
}
