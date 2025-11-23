package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.DisponibilidadeModel;
import com.professoronline.msescola.model.HorarioPadraoModel;
import com.professoronline.msescola.model.SemestreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DisponibilidadeRepository extends JpaRepository<DisponibilidadeModel, Integer> {
    @Query("SELECT new com.CodeMiners.apiback03.dto.DisponibilidadeDTO(d) " +
            "FROM Disponibilidade d " +
            "JOIN d.horarioPadrao h " +
            "WHERE d.professor = :professor " +
            "ORDER BY " +
            "CASE h.turno " +
            "   WHEN 'Matutino' THEN 1 " +
            "   WHEN 'Vespertino' THEN 2 " +
            "   WHEN 'Noturno' THEN 3 " +
            "   ELSE 4 END")
    List<DisponibilidadeDTO> findDTOByProfessorOrderByTurnoCustom(@Param("professor") Integer professor);

    boolean existsByProfessorAndHorarioPadraoAndSemestre(Integer professor, HorarioPadraoModel horarioPadrao, SemestreModel semestreModel);
}
