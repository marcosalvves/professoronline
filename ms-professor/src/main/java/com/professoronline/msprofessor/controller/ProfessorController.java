package com.professoronline.msprofessor.controller;

import com.professoronline.msprofessor.dto.PerfiProfessorDTO;
import com.professoronline.msprofessor.dto.ProfessorDTO;
import com.professoronline.msprofessor.dto.ProfessorStatusDTO;
import com.professoronline.msprofessor.service.ProfessorService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize; // <-- Import necessário
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProfessorController {

    private final ProfessorService professorService;

    public ProfessorController(ProfessorService professorService) {
        this.professorService = professorService;
    }

    // Rotas de criação e gestão de Professor (CRUD) - Apenas ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/professores/criar")
    public ResponseEntity<ProfessorDTO> salvarProfessor(@RequestBody ProfessorDTO professorDTO) {
        return ResponseEntity.ok(professorService.salvar(professorDTO));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/professores/{id}/buscar")
    public ResponseEntity<ProfessorDTO> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(professorService.buscarPorId(id));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/professores/listar")
    public ResponseEntity<List<ProfessorDTO>> listarTodos() {
        return ResponseEntity.ok(professorService.listarTodos());
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/admin/professores/{id}/atualizar")
    public ResponseEntity<ProfessorDTO> atualizarProfessor(@PathVariable Integer id, @RequestBody ProfessorDTO dto) {
        return ResponseEntity.ok(professorService.atualizarProfessor(id, dto));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("/admin/professores/{id}/deletar")
    public ResponseEntity<Void> deletarProfessor(@PathVariable Integer id) {
        professorService.deletarProfessor(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PatchMapping("/admin/professores/{id}/status")
    public ResponseEntity<ProfessorDTO> atualizarStatus(@PathVariable Integer id, @RequestBody ProfessorStatusDTO dto){
        return ResponseEntity.ok(professorService.atualizarStatus(id,dto));
    }

    // Rotas de consulta com filtro - Apenas ADMIN
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/professores/ativos")
    public ResponseEntity<List<ProfessorDTO>> listarProfessoresAtivos() {
        List<ProfessorDTO> professores = professorService.buscarProfessoresAtivos();
        return ResponseEntity.ok(professores);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/admin/professores/inativos")
    public ResponseEntity<List<ProfessorDTO>> listarProfessoresInativos() {
        List<ProfessorDTO> professores = professorService.buscarProfessoresInativos();
        return ResponseEntity.ok(professores);
    }

    // Perfil do Professor - Acessível por ADMIN e pelo próprio PROFESSOR
    @PreAuthorize("hasAnyRole('ADMIN', 'PROFESSOR')")
    @GetMapping("/professores/{nome}/perfil")
    public ResponseEntity<?> buscarPerfil(@PathVariable String nome){
        try{
            var response = professorService.buscarPerfil(nome);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // Em produção, deve-se usar um Handler mais robusto para exceções
            throw new RuntimeException(e);
        }
    }
}