package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.HorarioPadraoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HorarioPadraoRepository extends JpaRepository<HorarioPadraoModel, Integer> {
    List<HorarioPadraoModel> findByAtivo(Boolean ativo);
}
