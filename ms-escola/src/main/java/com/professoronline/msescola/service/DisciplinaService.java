package com.professoronline.msescola.service;

import com.professoronline.msescola.dto.DisciplinaDTO;
import com.professoronline.msescola.dto.DisciplinaStatusDTO;
import com.professoronline.msescola.model.DisciplinaModel;

import java.util.List;
import java.util.Optional;

public interface DisciplinaService {
    public DisciplinaModel toEntity(DisciplinaDTO disciplinaDTO) ;
    public DisciplinaDTO toDTO(DisciplinaModel disciplina);
    public void criarDisciplina(DisciplinaDTO disciplinaDTO);
    public List<DisciplinaDTO> buscarDisciplinas();
    public Optional<DisciplinaModel> buscarPorId(Integer id);
    public DisciplinaDTO salvar(DisciplinaDTO  disciplinaDTO);
    public DisciplinaDTO atualizarDisciplina(Integer id, DisciplinaDTO dto);
    public DisciplinaDTO atualizarStatus(Integer id, DisciplinaStatusDTO statusDTO);
    public List<DisciplinaDTO> buscarDisciplinasAtivas();
    public List<DisciplinaDTO> buscarDisciplinasInativas();
    public DisciplinaDTO deletarDisciplina(Integer disciplinaId);
}