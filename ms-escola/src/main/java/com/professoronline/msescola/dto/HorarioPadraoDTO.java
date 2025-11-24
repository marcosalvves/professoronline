package com.professoronline.msescola.dto;

import io.micrometer.common.lang.NonNull;

import java.time.LocalTime;

public record HorarioPadraoDTO(
        Integer id,
        @NonNull String turno,
        @NonNull LocalTime hora_inicio,
        @NonNull LocalTime hora_fim,
        @NonNull Boolean ativo,
        @NonNull String dia_semana
) {
}
