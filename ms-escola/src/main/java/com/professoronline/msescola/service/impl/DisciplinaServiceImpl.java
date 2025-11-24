package com.professoronline.msescola.service.impl;
import com.professoronline.msescola.dto.DisciplinaDTO;
import com.professoronline.msescola.dto.DisciplinaStatusDTO;
import com.professoronline.msescola.model.DisciplinaModel;
import com.professoronline.msescola.repository.DisciplinaRepository;
import com.professoronline.msescola.service.DisciplinaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DisciplinaServiceImpl implements DisciplinaService {

    private final DisciplinaRepository disciplinaRepository;

    @Autowired
    public DisciplinaServiceImpl(DisciplinaRepository disciplinaRepository) {
        this.disciplinaRepository = disciplinaRepository;
    }

    public DisciplinaModel toEntity(DisciplinaDTO disciplinaDTO) {
        DisciplinaModel disciplina = new DisciplinaModel();
        disciplina.setSigla(disciplinaDTO.sigla());
        disciplina.setDescricao(disciplinaDTO.descricao());
        disciplina.setCarga_horaria(disciplinaDTO.carga_horaria());
        return disciplina;
    }

    public DisciplinaDTO toDTO(DisciplinaModel disciplina) {
        return new DisciplinaDTO(
                disciplina.getId(),
                disciplina.getSigla(),
                disciplina.getDescricao(),
                disciplina.getCarga_horaria(),
                disciplina.getStatus()
        );
    }

    public void criarDisciplina(DisciplinaDTO disciplinaDTO) {
        DisciplinaModel disciplinaEntity = toEntity(disciplinaDTO);
        disciplinaEntity.setStatus(true);
        disciplinaRepository.save(disciplinaEntity);
    }

    public List<DisciplinaDTO> buscarDisciplinas() {
        return disciplinaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public Optional<DisciplinaModel> buscarPorId(Integer id) {
        return disciplinaRepository.findById(id);
    }

    public DisciplinaDTO salvar(DisciplinaDTO  disciplinaDTO) {
        DisciplinaModel disciplina = toEntity(disciplinaDTO);
        return toDTO(disciplinaRepository.save(disciplina));
    }

    public DisciplinaDTO atualizarDisciplina(Integer id, DisciplinaDTO dto) {
        DisciplinaModel disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: "+id));

        if(dto.sigla() != null){
            disciplina.setSigla(dto.sigla());
        }
        if(dto.descricao() != null){
            disciplina.setDescricao(dto.descricao());
        }
        if(dto.carga_horaria() != null){
            disciplina.setCarga_horaria(dto.carga_horaria());
        }

        return toDTO(disciplinaRepository.save(disciplina));
    }

    public DisciplinaDTO atualizarStatus(Integer id, DisciplinaStatusDTO statusDTO) {
        DisciplinaModel disciplina = disciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com o ID: "+id));

        disciplina.setStatus(statusDTO.status());
        DisciplinaModel disciplinaAtualizada = disciplinaRepository.save(disciplina);
        return toDTO(disciplinaAtualizada);
    }

    public List<DisciplinaDTO> buscarDisciplinasAtivas(){
        return disciplinaRepository.findByStatus(true).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public List<DisciplinaDTO> buscarDisciplinasInativas(){
        return disciplinaRepository.findByStatus(false).stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public DisciplinaDTO deletarDisciplina(Integer disciplinaId) {
        DisciplinaModel deleted = disciplinaRepository.findById(disciplinaId).orElseThrow(EntityNotFoundException::new);
        disciplinaRepository.deleteById(disciplinaId);
        return new DisciplinaDTO(disciplinaId,deleted.getSigla(),deleted.getDescricao(),deleted.getCarga_horaria(),deleted.getStatus());

    }
}