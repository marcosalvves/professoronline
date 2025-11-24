package com.professoronline.msescola.service.impl;


import com.professoronline.msescola.dto.SemestreDTO;
import com.professoronline.msescola.dto.SemestreStatusDTO;
import com.professoronline.msescola.model.SemestreModel;
import com.professoronline.msescola.repository.SemestreRepository;
import com.professoronline.msescola.service.SemestreService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemestreServiceImpl implements SemestreService {

    private final SemestreRepository semestreRepository;

    public SemestreServiceImpl(SemestreRepository semestreRepository) {
        this.semestreRepository = semestreRepository;
    }

    private SemestreDTO converterParaDTO(SemestreModel semestre) {
        return new SemestreDTO(semestre);
    }

    private SemestreModel converterParaEntidade(SemestreDTO semestreDTO) {

        SemestreModel semestre = new SemestreModel();

        semestre.setAno(semestreDTO.ano());
        semestre.setPeriodoAno(semestreDTO.periodoAno());
        semestre.setStatus(semestreDTO.status());

        return semestre;
    }

    @Override
    public SemestreDTO salvarSemestre(SemestreDTO semestreDTO) {
        SemestreModel semestre = converterParaEntidade(semestreDTO);
        return converterParaDTO(semestreRepository.save(semestre));
    }

    @Override
    public List<SemestreDTO> listarSemestres() {
        return semestreRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public SemestreDTO listarSemestrePorId(Integer id) {
        return semestreRepository.findById(id)
        .map(this::converterParaDTO)
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado"));
    }

    @Override
    public void deletarSemestrePorID(Integer id) {
        SemestreModel semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado com o ID: " +id));
        semestreRepository.delete(semestre);
    }

    @Override
    public SemestreDTO alterarStatus(Integer id, SemestreStatusDTO semestreStatusDTO) {
        SemestreModel semestre = semestreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado com o ID: "+id));

        semestre.setStatus(semestreStatusDTO.status());

        return converterParaDTO(semestreRepository.save(semestre));
    }
}
