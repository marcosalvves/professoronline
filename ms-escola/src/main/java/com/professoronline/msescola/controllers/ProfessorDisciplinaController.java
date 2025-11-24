package com.professoronline.msescola.controllers;

import com.professoronline.msescola.service.ProfessorDisciplinaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorDisciplinaController {

    private final ProfessorDisciplinaService professorDisciplinaService;

    public ProfessorDisciplinaController(ProfessorDisciplinaService professorDisciplinaService){ this.professorDisciplinaService = professorDisciplinaService; }

    @DeleteMapping("/admin/professores-disciplinas/{id}/deletar")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        professorDisciplinaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/professores-disciplinas/quantidade-interessados/{id}") //id da disciplina
    public ResponseEntity<Integer> quantidadeInteressados(@PathVariable Integer id){
        return ResponseEntity.ok(professorDisciplinaService.quantidadeInteressados(id));
    }
}
