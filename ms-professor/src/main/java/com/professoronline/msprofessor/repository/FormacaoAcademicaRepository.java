package com.professoronline.msprofessor.repository;

import com.professoronline.msprofessor.model.FormacaoAcademica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FormacaoAcademicaRepository extends JpaRepository<FormacaoAcademica, Integer> {

    // Método customizado para buscar todas as formações de um professor específico
    List<FormacaoAcademica> findByIdProfessor_IdProfessor(Integer professorId);
}