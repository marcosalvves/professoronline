package com.professoronline.msescola.service;


import com.professoronline.msescola.dto.DisponibilidadeDTO;

import java.util.List;

public interface DisponibilidadeService {
    DisponibilidadeDTO criar(DisponibilidadeDTO dto);
    List<DisponibilidadeDTO> listaOrdenada(Integer idProfessor);
    List<DisponibilidadeDTO> listar();
    DisponibilidadeDTO atualizar(Integer id, DisponibilidadeDTO dto);
    void deletar(Integer id);
}
