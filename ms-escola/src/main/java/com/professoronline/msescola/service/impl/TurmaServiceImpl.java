package com.professoronline.msescola.service.impl;

import com.professoronline.msescola.dto.TurmaDTO;
import com.professoronline.msescola.dto.TurmaResponseDTO;
import com.professoronline.msescola.repository.*;
import com.professoronline.msescola.service.TurmaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TurmaServiceImpl implements TurmaService {

    private final TurmaRepository turmaRepository;
    //private final ProfessorRepository professorRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final SemestreRepository semestreRepository;
    private final HorarioPadraoRepository horarioPadraoRepository;
    private final DisponibilidadeRepository disponibilidadeRepository; // Repositório para a tabela de disponibilidade

    public TurmaServiceImpl(TurmaRepository turmaRepository, DisciplinaRepository disciplinaRepository, SemestreRepository semestreRepository, HorarioPadraoRepository horarioPadraoRepository, DisponibilidadeRepository disponibilidadeRepository) {
        this.turmaRepository = turmaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.semestreRepository = semestreRepository;
        this.horarioPadraoRepository = horarioPadraoRepository;
        this.disponibilidadeRepository = disponibilidadeRepository;
    }

    @Override
    public TurmaDTO criarTurma(TurmaDTO dto) {
        return null;
    }

    @Override
    public List<TurmaResponseDTO> listar() {
        return List.of();
    }
}
