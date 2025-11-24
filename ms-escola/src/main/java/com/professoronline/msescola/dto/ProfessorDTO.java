package com.professoronline.msescola.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public record ProfessorDTO(
        // Mapeia o campo "id" do JSON para "idProfessor"
        @JsonProperty("id")
        Integer idProfessor,

        @JsonProperty("nome")
        String nome, // Antigo: professor.getIdUsuario().getNome()

        @JsonProperty("registro")
        String registroProfessor,

        @JsonProperty("ativo")
        Boolean statusProfessor,

        // O serviço externo deve retornar a lista de disciplinas vinculadas
        @JsonProperty("disciplinas")
        List<DisciplinaAssociadaDTO> disciplinas
) {
}
