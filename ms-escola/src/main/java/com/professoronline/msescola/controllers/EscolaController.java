package com.professoronline.msescola.controllers;

import com.professoronline.msescola.dto.EscolaDTO;
import com.professoronline.msescola.dto.EscolaStatusDTO;
import com.professoronline.msescola.model.EscolaModel;
import com.professoronline.msescola.service.EscolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class EscolaController {
    private final EscolaService escolaService;

    @Autowired
    public EscolaController(EscolaService escolaService) {
        this.escolaService = escolaService;
    }

    @PostMapping("/admin/escolas/criar") // obrigatorio
    public ResponseEntity<EscolaDTO> criarEscola(@RequestBody EscolaDTO escolaDTO) {
        escolaService.criarEscola(escolaDTO);
        return new ResponseEntity<>(escolaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/admin/escolas/{id}/atualizar") // obrigatorio
    public ResponseEntity<EscolaDTO> atualizarEscola(@PathVariable Integer id, @RequestBody EscolaDTO escolaDTO) {
        escolaService.atualizarEscola(id, escolaDTO);
        return new ResponseEntity<>(escolaDTO, HttpStatus.CREATED);
    }

    @PutMapping("/admin/escolas/{id}/status") // obrigatorio
    public ResponseEntity<EscolaStatusDTO> atualizarStatus(@PathVariable Integer id, @RequestBody EscolaStatusDTO status) {
        escolaService.atualizarStatus(id, status);
        return  new ResponseEntity<>(status, HttpStatus.OK);
    }

    @GetMapping("/admin/escolas/listar") //obrigatorio
    public List<EscolaModel> listarEscolas() {
        return escolaService.listarEscolas();
    }

    @DeleteMapping("/admin/escolas/{id}/deletar")
    public ResponseEntity<Void> deletarEscola(@PathVariable Integer id) {
            escolaService.deletarEscolas(id);
            return  new ResponseEntity<>(HttpStatus.OK);
        }
    }





