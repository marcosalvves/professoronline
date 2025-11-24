package com.professoronline.msescola.service;

import com.professoronline.msescola.dto.HorarioPadraoDTO;
import com.professoronline.msescola.model.HorarioPadraoModel;

import java.util.List;

public interface HorarioPadraoService {
    public HorarioPadraoModel toEntity(HorarioPadraoDTO horarioPadraoDTO);
    public HorarioPadraoDTO toDTO(HorarioPadraoModel horarioPadrao);
    public void criarHorarioPadrao(HorarioPadraoDTO horarioPadraoDTO);
    public List<HorarioPadraoDTO> buscarHorarios();
    public List<HorarioPadraoDTO> buscarHorariosAtivos();
    public HorarioPadraoModel atualizarHorario(Integer id, HorarioPadraoDTO horarioPadraoDTO);
}
