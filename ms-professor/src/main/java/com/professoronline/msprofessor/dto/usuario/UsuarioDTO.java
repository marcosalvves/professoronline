package com.professoronline.msprofessor.dto.usuario;

import java.util.List;

public record UsuarioDTO(
        int id,
        String nome,
        String email,
        String senha,
        List<Integer> tipos
) {
}
