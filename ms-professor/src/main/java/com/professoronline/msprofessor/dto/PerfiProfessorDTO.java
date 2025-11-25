package com.professoronline.msprofessor.dto;

import java.util.List;

public record PerfiProfessorDTO(Integer idProfessor,
                                String nomeProfessor,// vindo de usuario.nome ou do próprio professor, conforme teu modelo
                                Boolean statusProfessor,
                                List<DisciplinaDTO> disciplinas,
                                List<FormacaoAcademicaDTO> formacoes,
                                List<TurmaDTO> turmas) {
}
