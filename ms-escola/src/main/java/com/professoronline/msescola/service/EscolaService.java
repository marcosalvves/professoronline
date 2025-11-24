package com.professoronline.msescola.service;

import com.professoronline.msescola.dto.EscolaDTO;
import com.professoronline.msescola.dto.EscolaStatusDTO;
import com.professoronline.msescola.model.EscolaModel;

import java.util.List;

public interface EscolaService {

    public EscolaModel toEntity(EscolaDTO escolaDTO);
    public void criarEscola(EscolaDTO escolaDTO);
    public EscolaModel buscarPorId(Integer id);
    public void atualizarEscola(Integer id, EscolaDTO escolaDTO);
    public void atualizarStatus(Integer id, EscolaStatusDTO status);
    public List<EscolaModel> listarEscolas();
    public void deletarEscolas(Integer id);

}
