package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.EscolaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EscolaRepository extends JpaRepository<EscolaModel, Integer> {

}
