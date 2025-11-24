package com.professoronline.msescola.repository;

import com.professoronline.msescola.model.HorarioPadraoModel;
import com.professoronline.msescola.model.SemestreModel;
import com.professoronline.msescola.model.TurmaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<TurmaModel, Integer> {
    boolean existsByProfessorAndHorarioPadraoAndSemestre(Integer professor, HorarioPadraoModel horarioPadrao, SemestreModel semestre);
}
