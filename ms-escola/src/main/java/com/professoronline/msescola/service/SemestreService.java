package com.professoronline.msescola.service;


import com.professoronline.msescola.dto.SemestreDTO;
import com.professoronline.msescola.dto.SemestreStatusDTO;

import java.util.List;

public interface SemestreService {
    public SemestreDTO salvarSemestre(SemestreDTO semestreDTO);
    List<SemestreDTO> listarSemestres();
    SemestreDTO listarSemestrePorId(Integer id);
    void deletarSemestrePorID(Integer id);
    SemestreDTO alterarStatus(Integer id, SemestreStatusDTO semestreStatusDTO);
}
