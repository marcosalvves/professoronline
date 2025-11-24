package com.professoronline.msescola.controllers;

import com.professoronline.msescola.dto.SemestreDTO;
import com.professoronline.msescola.service.SemestreService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class SemestreController {

    private final com.professoronline.msescola.service.SemestreService semestreService;

    public SemestreController(SemestreService semestreService) {
        this.semestreService = semestreService;
    }

    @GetMapping("/admin/semestres/{id}/buscar")
    public ResponseEntity<SemestreDTO> listarSemestrePorId(@PathVariable Integer id) {
        return ResponseEntity.ok(semestreService.listarSemestrePorId(id));
    }

    @DeleteMapping("/admin/semestres/{id}/deletar")
    public ResponseEntity<?> deleteSemestrePorId(@PathVariable Integer id, HttpServletResponse response) {
        try {
            semestreService.deletarSemestrePorID(id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Semestre não pode ser deletado, pois existe uma ou mais turmas associadas a ele !!");
        }
        return  ResponseEntity.status(200).build();
    }

}