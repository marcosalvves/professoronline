package com.professoronline.msescola.service.impl;


import com.professoronline.msescola.dto.HorarioPadraoDTO;
import com.professoronline.msescola.model.HorarioPadraoModel;
import com.professoronline.msescola.repository.HorarioPadraoRepository;
import com.professoronline.msescola.service.HorarioPadraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HorarioPadraoServiceImpl implements HorarioPadraoService {
    private final HorarioPadraoRepository horarioPadraoRepository;

    @Autowired
    public HorarioPadraoServiceImpl(HorarioPadraoRepository horarioPadraoRepository) { this.horarioPadraoRepository = horarioPadraoRepository; }

    public HorarioPadraoModel toEntity(HorarioPadraoDTO horarioPadraoDTO) {
        HorarioPadraoModel horarioPadrao = new HorarioPadraoModel();
        horarioPadrao.setTurno(horarioPadraoDTO.turno());
        horarioPadrao.setHora_inicio(horarioPadraoDTO.hora_inicio());
        horarioPadrao.setHora_fim(horarioPadraoDTO.hora_fim());
        horarioPadrao.setAtivo(horarioPadraoDTO.ativo());
        horarioPadrao.setDia_semana(horarioPadraoDTO.dia_semana());
        return horarioPadrao;
    }

    public HorarioPadraoDTO toDTO(HorarioPadraoModel horarioPadrao) {
        return new HorarioPadraoDTO(
                horarioPadrao.getId(),
                horarioPadrao.getTurno(),
                horarioPadrao.getHora_inicio(),
                horarioPadrao.getHora_fim(),
                horarioPadrao.getAtivo(),
                horarioPadrao.getDia_semana()
        );
    }

    public void criarHorarioPadrao(HorarioPadraoDTO horarioPadraoDTO) {
        HorarioPadraoModel horarioPadraoEntity = toEntity(horarioPadraoDTO);
        horarioPadraoRepository.save(horarioPadraoEntity);
    }

    public List<HorarioPadraoDTO> buscarHorarios(){
        return horarioPadraoRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<HorarioPadraoDTO> buscarHorariosAtivos() {
        return horarioPadraoRepository.findByAtivo(true).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public HorarioPadraoModel atualizarHorario(Integer id, HorarioPadraoDTO horarioPadraoDTO) {
        HorarioPadraoModel horarioPadrao = horarioPadraoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Horário não encontrado com o ID: "+id));

        if(horarioPadraoDTO.hora_inicio() != null){
            horarioPadrao.setHora_inicio(horarioPadraoDTO.hora_inicio());
        }
        if(horarioPadraoDTO.hora_fim() != null){
            horarioPadrao.setHora_fim(horarioPadraoDTO.hora_fim());
        }
        return horarioPadraoRepository.save(horarioPadrao);
    }

}
