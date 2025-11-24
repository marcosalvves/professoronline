package com.professoronline.msescola.controllers;


import com.professoronline.msescola.dto.TurmaDTO;
import com.professoronline.msescola.dto.TurmaResponseDTO;
import com.professoronline.msescola.service.TurmaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TurmaController {
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    /*
    // obrigatorio
    @PostMapping("/admin/turmas/criar")
    public ResponseEntity<TurmaDTO> criarTurma(@RequestBody TurmaDTO dto) {
        TurmaDTO novaTurma = turmaService.criarTurma(dto);
        return new ResponseEntity<>(novaTurma, HttpStatus.CREATED);

    }
*/
    @GetMapping("/admin/turmas")
    public ResponseEntity<List<TurmaResponseDTO>> listar(){
    List<TurmaResponseDTO> response = turmaService.listar();
    return response.isEmpty() ?
            ResponseEntity.noContent().build() :
            ResponseEntity.ok().body(response);
    }

}
