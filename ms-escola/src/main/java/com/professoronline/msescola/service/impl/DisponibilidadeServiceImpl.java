package com.professoronline.msescola.service.impl;

import com.professoronline.msescola.dto.DisponibilidadeDTO;
import com.professoronline.msescola.model.DisponibilidadeModel;
import com.professoronline.msescola.model.HorarioPadraoModel;
import com.professoronline.msescola.model.SemestreModel;
import com.professoronline.msescola.repository.DisponibilidadeRepository;
import com.professoronline.msescola.repository.HorarioPadraoRepository;
import com.professoronline.msescola.repository.SemestreRepository;
import com.professoronline.msescola.service.DisponibilidadeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DisponibilidadeServiceImpl implements DisponibilidadeService {

    private final DisponibilidadeRepository disponibilidadeRepository;
    private final HorarioPadraoRepository horarioPadraoRepository;
    private final SemestreRepository semestreRepository;

    public DisponibilidadeServiceImpl(DisponibilidadeRepository disponibilidadeRepository,
                                      HorarioPadraoRepository horarioPadraoRepository,
                                      SemestreRepository semestreRepository) {
        this.disponibilidadeRepository = disponibilidadeRepository;
        this.horarioPadraoRepository = horarioPadraoRepository;
        this.semestreRepository = semestreRepository;
    };
    private DisponibilidadeModel toEntity(DisponibilidadeDTO dto) {
        DisponibilidadeModel entity = new DisponibilidadeModel();
        HorarioPadraoModel horarioPadrao = horarioPadraoRepository.findById(dto.idHorarioPadrao())
                .orElseThrow(() -> new RuntimeException("Horário não encontrado"));

        SemestreModel semestre = semestreRepository.findById(dto.idSemestre())
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado"));

        if (Boolean.FALSE.equals(horarioPadrao.getAtivo())){
            throw new RuntimeException("Não é possível cadastrar no horário inativo.");
        }
        entity.setHorarioPadraoModel(horarioPadrao);
        entity.setSemestreModel(semestre);
        return entity;
    }


    @Override
    public DisponibilidadeDTO criar(DisponibilidadeDTO dto) {
        return null;
    }

    @Override
    public List<DisponibilidadeDTO> listaOrdenada(Integer idProfessor) {
        return List.of();
    }

    @Override
    public List<DisponibilidadeDTO> listar() {
        return List.of();
    }

    @Override
    public DisponibilidadeDTO atualizar(Integer id, DisponibilidadeDTO dto) {
        return null;
    }


    @Override
    public void deletar(Integer id) { disponibilidadeRepository.deleteById(id); }

}
