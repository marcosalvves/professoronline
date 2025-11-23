package com.professoronline.msescola.repository;

import com.CodeMiners.apiback03.dto.ProfessorDisciplinaNomesDTO;
import com.CodeMiners.apiback03.model.ProfessorDisciplina;
import com.professoronline.msescola.model.ProfessorDisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProfessorDisciplinaRepository extends JpaRepository<ProfessorDisciplinaModel, Integer> {
    List<ProfessorDisciplinaModel> findAll();

    @Query("SELECT new com.CodeMiners.apiback03.dto.ProfessorDisciplinaNomesDTO(" +
            "pd.professor.idUsuario.nome, " +
            "pd.disciplina.descricao, " +
            "pd.prioridade, " +
            "pd.semestre.periodoAno)"+
            "FROM ProfessorDisciplina pd")
    List<ProfessorDisciplinaNomesDTO> professoresDisciplina();

    List<ProfessorDisciplinaModel> getProfessorDisciplinaByDisciplinaId(Integer disciplinaId);
    Integer countByDisciplina_Id(Integer disciplina_Id);
}
