package com.professoronline.msescola.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DisciplinaAssociadaDTO(
        @JsonProperty("descricao")
        String descricao, // Antigo: disciplina.getDisciplina().getDescricao()

        @JsonProperty("prioridade")
        Integer prioridade,

        // O serviço externo já deve mandar o período legível (ex: "2025.1")
        @JsonProperty("periodo")
        String periodoAno
) {
}
