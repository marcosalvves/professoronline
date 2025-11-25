package com.professoronline.msprofessor.service;

import com.professoronline.msprofessor.dto.PerfiProfessorDTO;
import com.professoronline.msprofessor.dto.ProfessorDTO;
import com.professoronline.msprofessor.dto.ProfessorStatusDTO;
import com.professoronline.msprofessor.model.Professor;

import java.util.List;

public interface ProfessorService {
    ProfessorDTO salvar(ProfessorDTO dto);
    ProfessorDTO buscarPorId(Integer id);
    List<ProfessorDTO> listarTodos();
    ProfessorDTO atualizarProfessor(Integer id, ProfessorDTO dto);
    void deletarProfessor(Integer id);
    ProfessorDTO atualizarStatus(Integer id, ProfessorStatusDTO dto);
    List<ProfessorDTO> buscarProfessoresAtivos();
    List<ProfessorDTO> buscarProfessoresInativos();
    PerfiProfessorDTO buscarPerfil(String nome);

}
