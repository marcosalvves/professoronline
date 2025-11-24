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

    // Query corrigida para buscar a lista ordenada
    @Query("SELECT d " +
            "FROM DisponibilidadeModel d " +
            "JOIN d.horarioPadraoModel h " +
            "WHERE d.idProfessor = :professorId " +
            "ORDER BY " +
            "CASE h.turno " +
            "   WHEN 'Matutino' THEN 1 " +
            "   WHEN 'Vespertino' THEN 2 " +
            "   WHEN 'Noturno' THEN 3 " +
            "   ELSE 4 END")
    List<DisponibilidadeModel> findByProfessorIdOrderByTurnoCustom(@Param("professorId") Integer professorId);

    // Query manual para verificar existência (evita o erro de parse do "IdProfessor")
    @Query("SELECT COUNT(d) > 0 " +
            "FROM DisponibilidadeModel d " +
            "WHERE d.idProfessor = :professorId " +
            "AND d.horarioPadraoModel = :horario " +
            "AND d.semestreModel = :semestre")
    boolean existsDuplicidade(@Param("professorId") Integer professorId,
                              @Param("horario") HorarioPadraoModel horario,
                              @Param("semestre") SemestreModel semestre);
}