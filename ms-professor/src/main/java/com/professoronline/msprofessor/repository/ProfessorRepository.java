package com.professoronline.msprofessor.repository;

import com.professoronline.msprofessor.dto.PerfiProfessorDTO;
import com.professoronline.msprofessor.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {
    Optional<Professor> findByRegistroProfessor(String registroProfessor);
    List<Professor> findByStatusProfessor(boolean status);
    @Query("SELECT p FROM Professor p WHERE p.idUsuario.id = :idUsuario")
    Optional<Professor> buscarPorIdUsuario(@Param("idUsuario") Integer idUsuario);



}
