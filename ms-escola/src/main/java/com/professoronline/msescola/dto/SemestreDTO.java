package com.professoronline.msescola.dto;

import com.professoronline.msescola.model.SemestreModel;

public record SemestreDTO(
        Integer id,
        Integer ano,
        String periodoAno,
        Boolean status
) {
    public SemestreDTO(SemestreModel semestre) {
        this(
                semestre.getId(),
                semestre.getAno(),
                semestre.getPeriodoAno(),
                semestre.getStatus()
        );
    }
}
