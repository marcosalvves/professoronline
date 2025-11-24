package com.professoronline.msescola.service.impl;


import com.professoronline.msescola.dto.ProfessorDisciplinaDTO;
import com.professoronline.msescola.dto.ProfessorDisciplinaNomesDTO;
import com.professoronline.msescola.model.DisciplinaModel;
import com.professoronline.msescola.model.ProfessorDisciplinaModel;
import com.professoronline.msescola.model.SemestreModel;
import com.professoronline.msescola.repository.DisciplinaRepository;
import com.professoronline.msescola.repository.ProfessorDisciplinaRepository;
import com.professoronline.msescola.repository.SemestreRepository;
import com.professoronline.msescola.service.ProfessorDisciplinaService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorDisciplinaServiceImpl implements ProfessorDisciplinaService {

    private final ProfessorDisciplinaRepository professorDisciplinaRepository;
    private final DisciplinaRepository disciplinaRepository;
    private final SemestreRepository semestreRepository;

    public ProfessorDisciplinaServiceImpl(ProfessorDisciplinaRepository professorDisciplinaRepository,
                                          DisciplinaRepository disciplinaRepository,
                                          SemestreRepository semestreRepository){
        this.professorDisciplinaRepository = professorDisciplinaRepository;
        this.disciplinaRepository = disciplinaRepository;
        this.semestreRepository = semestreRepository;
    }

    private ProfessorDisciplinaDTO toDTO(ProfessorDisciplinaModel professorDisciplina) {
        return new ProfessorDisciplinaDTO(professorDisciplina);
    }

    private ProfessorDisciplinaModel toEntity(ProfessorDisciplinaDTO dto){
        ProfessorDisciplinaModel entity = new ProfessorDisciplinaModel();

        DisciplinaModel disciplina = disciplinaRepository.findById(dto.idDisciplina())
                .orElseThrow(() -> new RuntimeException("Disciplina não encontrada"));

        SemestreModel semestre = semestreRepository.findById(dto.idSemestre())
                .orElseThrow(() -> new RuntimeException("Semestre não encontrado"));

        if(Boolean.FALSE.equals(disciplina.getStatus())){
            throw new RuntimeException("Não é possível cadastrar na disciplina inativa.");
        }

        entity.setDisciplinaModel(disciplina);
        entity.setSemestreModel(semestre);
        entity.setPrioridade(dto.prioridade());
        return entity;
    }

    @Override
    public ProfessorDisciplinaDTO criar(ProfessorDisciplinaDTO dto) {
        ProfessorDisciplinaModel professorDisciplina = toEntity(dto);
        return toDTO(professorDisciplinaRepository.save(professorDisciplina));
    }

    @Override
    public List<ProfessorDisciplinaDTO> listarTudo(){
        return professorDisciplinaRepository.findAll()
                .stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfessorDisciplinaNomesDTO> listarNomes() {
        return List.of();
    }

    @Override
    public ProfessorDisciplinaDTO atualizar(Integer id, ProfessorDisciplinaDTO dto) {
        ProfessorDisciplinaModel entity = professorDisciplinaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ProfessorDisciplina não encontrado com ID: "+id));

        if (dto.idDisciplina() != null){
            DisciplinaModel disciplina = disciplinaRepository.findById(dto.idDisciplina())
                    .orElseThrow(() -> new RuntimeException("Disciplina não encontrada com ID: "+dto.idDisciplina()));
            entity.setDisciplinaModel(disciplina);
        }
        if(dto.idSemestre() != null){
            SemestreModel semestre = semestreRepository.findById(dto.idSemestre())
                    .orElseThrow(() -> new RuntimeException("Semestre não encontrado com ID: "+dto.idSemestre()));
            entity.setSemestreModel(semestre);
        }
        if(dto.prioridade() != null){
            entity.setPrioridade(dto.prioridade());
        }
        return toDTO(professorDisciplinaRepository.save(entity));
    }

    @Override
    public void deletar(Integer id){
        professorDisciplinaRepository.deleteById(id);
    }

    @Override
    public List<ProfessorDisciplinaDTO> listarInteressados(Integer id) {
        return List.of();
    }

    @Override
    public Integer quantidadeInteressados(Integer idDisciplina) {
        return 0;
    }


}
