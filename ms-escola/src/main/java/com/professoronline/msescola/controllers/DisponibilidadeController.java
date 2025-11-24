package com.professoronline.msescola.controllers;

import com.professoronline.msescola.dto.DisponibilidadeDTO;
import com.professoronline.msescola.service.DisponibilidadeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DisponibilidadeController {

    private final DisponibilidadeService disponibilidadeService;

    public  DisponibilidadeController(DisponibilidadeService disponibilidadeService) { this.disponibilidadeService = disponibilidadeService; }

/*
    @GetMapping("/admin/disponibilidade/ordenada/{id}")
    public ResponseEntity<List<DisponibilidadeDTO>> listaOrdenada(@PathVariable Integer id) {
        return ResponseEntity.ok(disponibilidadeService.listaOrdenada(id));
    }

    @GetMapping("/admin/disponibilidade/listar")
    public ResponseEntity<List<DisponibilidadeDTO>> listarDisponibilidade() {
        return ResponseEntity.ok(disponibilidadeService.listar());
    }

    @PutMapping("/professor/disponibilidade/{id}/atualizar")
    public ResponseEntity<DisponibilidadeDTO> atualizar(@PathVariable Integer id, @RequestBody DisponibilidadeDTO dto) {
        return ResponseEntity.ok(disponibilidadeService.atualizar(id,dto));
    }

    @DeleteMapping("/professor/disponibilidade/{id}/deletar")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
            disponibilidadeService.deletar(id);
            return ResponseEntity.noContent().build();
    }


 */
}
