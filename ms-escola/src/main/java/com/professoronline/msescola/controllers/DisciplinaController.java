package com.professoronline.msescola.controllers;

import com.professoronline.msescola.dto.DisciplinaDTO;
import com.professoronline.msescola.dto.DisciplinaStatusDTO;
import com.professoronline.msescola.service.DisciplinaService;
import com.professoronline.msescola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


    @RestController
    @RequestMapping("/api")
    public class DisciplinaController {

        private final DisciplinaService disciplinaService;
        private final EscolaService escolaService;

        @Autowired
        public DisciplinaController(DisciplinaService disciplinaService, EscolaService escolaService) {
            this.disciplinaService = disciplinaService;
            this.escolaService = escolaService;
        }

        @PostMapping("/admin/disciplinas/criar") // obrigatorio
        public ResponseEntity<DisciplinaDTO> criarDisciplina(@RequestBody DisciplinaDTO disciplinaDTO) {
            disciplinaService.criarDisciplina(disciplinaDTO);
            return new ResponseEntity<>(disciplinaDTO, HttpStatus.CREATED);
        }

        @GetMapping("/admin/disciplinas/listar") // obrigatorio
        public ResponseEntity<List<DisciplinaDTO>> listarDisciplinas() {
            List<DisciplinaDTO> disciplinas = disciplinaService.buscarDisciplinas();
            return ResponseEntity.ok(disciplinas);
        }

        @PutMapping("/admin/disciplinas/{id}/atualizar") // obrigatorio
        public ResponseEntity<DisciplinaDTO> atualizarDisciplina(@PathVariable Integer id, @RequestBody DisciplinaDTO dto) {
            try {
                DisciplinaDTO disciplinaAtualizada = disciplinaService.atualizarDisciplina(id, dto);
                return ResponseEntity.ok(disciplinaAtualizada);
            } catch (RuntimeException e) {
                return ResponseEntity.notFound().build();
            }
        }

        @PutMapping("/admin/disciplinas/{id}/status") // obrigatorio
        public ResponseEntity<DisciplinaDTO> atualizarStatus(@PathVariable Integer id, @RequestBody DisciplinaStatusDTO statusDTO) {
            try{
                DisciplinaDTO disciplina = disciplinaService.atualizarStatus(id, statusDTO);
                return ResponseEntity.ok(disciplina);
            }catch (RuntimeException e){
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/professor/disciplinas/ativas") // obrigatorio
        public ResponseEntity<List<DisciplinaDTO>> listarDisciplinasAtivas(){
            List<DisciplinaDTO> disciplinas = disciplinaService.buscarDisciplinasAtivas();
            return  ResponseEntity.ok(disciplinas);
        }

        @GetMapping("/professor/disciplinas/inativas") // obrigatorio
        public ResponseEntity<List<DisciplinaDTO>> listarDisciplinasInativas(){
            List<DisciplinaDTO> disciplinas = disciplinaService.buscarDisciplinasInativas();
            return  ResponseEntity.ok(disciplinas);
        }

        @DeleteMapping("/admin/disciplinas/{id}")
        public ResponseEntity<?> deletarDisciplina(@PathVariable Integer id) {
            try {
                disciplinaService.deletarDisciplina(id);
                return ResponseEntity.noContent().build();
            } catch (Exception e) {
                return ResponseEntity.status(403).body("Disciplina associada a uma turma, por favor exclua a turma antes");
            }
        }
}
