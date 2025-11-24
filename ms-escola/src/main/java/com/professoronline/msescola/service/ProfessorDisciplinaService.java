package com.professoronline.msescola.service;

import com.professoronline.msescola.dto.ProfessorDisciplinaDTO;
import com.professoronline.msescola.dto.ProfessorDisciplinaNomesDTO;

import java.util.List;

public interface ProfessorDisciplinaService {
    ProfessorDisciplinaDTO criar(ProfessorDisciplinaDTO dto);
    List<ProfessorDisciplinaDTO> listarTudo();
    List<ProfessorDisciplinaNomesDTO> listarNomes();
    ProfessorDisciplinaDTO atualizar(Integer id, ProfessorDisciplinaDTO dto);
    void deletar(Integer id);

    List<ProfessorDisciplinaDTO> listarInteressados(Integer id);
    Integer quantidadeInteressados(Integer idDisciplina);
}
