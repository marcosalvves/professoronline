package com.professoronline.msescola.service;

import com.professoronline.msescola.dto.TurmaDTO;

import java.util.List;

public interface TurmaService {
    public TurmaDTO criarTurma(TurmaDTO dto);
    public List<com.professoronline.msescola.dto.TurmaResponseDTO> listar();
}
