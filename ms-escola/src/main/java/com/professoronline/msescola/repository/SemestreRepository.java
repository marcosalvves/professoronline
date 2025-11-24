package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.SemestreModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SemestreRepository extends JpaRepository<SemestreModel, Integer> {
}
