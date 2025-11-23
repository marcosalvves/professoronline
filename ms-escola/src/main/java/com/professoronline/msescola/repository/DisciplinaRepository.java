package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.DisciplinaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DisciplinaRepository extends JpaRepository<DisciplinaModel, Integer> {
    Optional<DisciplinaModel> findById(Integer id);
    List<DisciplinaModel> findByStatus(boolean status);
}
