package com.professoronline.msescola.dto;

import com.professoronline.msescola.model.DisponibilidadeModel;

import java.util.List;

public record DisponibilidadeDTO(
        Integer idProfessor,
        Integer idHorarioPadrao,
        Integer idSemestre,
        Integer professor,
        HorarioPadraoDTO horarioPadrao,
        String semestrePeriodoAno,
        List<ProfessorDisciplinaNomesDTO> professorDisciplinaNomesDTOList



 )
{
/*
    public DisponibilidadeDTO(DisponibilidadeModel disponibilidade) {
        this(
                disponibilidade.getProfessor().getClass();
        disponibilidade.getHorarioPadraoModel().getId(),
                disponibilidade.getSemestreModel().getId(),
                toProfessorDTO(disponibilidade.getProfessor()),
                toHorarioPadraoDTO(disponibilidade.getHorarioPadraoModel()),
                disponibilidade.getSemestreModel().getPeriodoAno(),
                disponibilidade
                        .getProfessor()
                        .getDisciplinas().stream().map(disciplina -> {
                            return new ProfessorDisciplinaNomesDTO(disciplina.getProfessor().getNome(),
                                    disciplina.getDisciplina().getDescricao(),
                                    disciplina.getPrioridade(),
                                    disciplina.getSemestre().getPeriodoAno());
                        }).toList()



        );
    }

/*
    private static HorarioPadraoDTO toHorarioPadraoDTO(HorarioPadrao horarioPadrao){
        return new HorarioPadraoDTO(horarioPadrao.getId(),
                horarioPadrao.getTurno(),
                horarioPadrao.getHora_inicio(),
                horarioPadrao.getHora_fim(),
                horarioPadrao.getAtivo(),
                horarioPadrao.getDia_semana());
    }

    private static ProfessorDTO toProfessorDTO(Professor professor){
        return new ProfessorDTO(professor.getIdProfessor(),
                professor.getIdUsuario().getId(),
                professor.getIdEscola().getId(),
                professor.getRegistroProfessor(),
                professor.getStatusProfessor(),
                professor.getIdUsuario().getNome(),
                professor.getIdEscola().getNome());
    } */
}
