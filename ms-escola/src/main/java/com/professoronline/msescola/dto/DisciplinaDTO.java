package com.professoronline.msescola.dto;

import io.micrometer.common.lang.NonNull;

public record DisciplinaDTO(
        Integer id,
        @NonNull String sigla,
        @NonNull String descricao,
        @NonNull Integer carga_horaria,
        @NonNull Boolean status
) {
}
