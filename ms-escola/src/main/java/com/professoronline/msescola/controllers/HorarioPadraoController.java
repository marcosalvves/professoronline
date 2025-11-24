package com.professoronline.msescola.controllers;

import com.professoronline.msescola.dto.HorarioPadraoDTO;
import com.professoronline.msescola.model.HorarioPadraoModel;
import com.professoronline.msescola.service.HorarioPadraoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class HorarioPadraoController {
    private final HorarioPadraoService horarioPadraoService;

    @Autowired
    public HorarioPadraoController(HorarioPadraoService horarioPadraoService) {
        this.horarioPadraoService = horarioPadraoService;
    }

    @PostMapping("/admin/horarios/criar") // obrigatorio
    public ResponseEntity<HorarioPadraoDTO> criarHorarioPadrao(@RequestBody HorarioPadraoDTO horarioPadraoDTO) {
        horarioPadraoService.criarHorarioPadrao(horarioPadraoDTO);
        return new  ResponseEntity<>(horarioPadraoDTO, HttpStatus.CREATED);
    }

    @GetMapping("/admin/horarios/padrao") // obrigatorio
    public ResponseEntity<List<HorarioPadraoDTO>> listarHorarioPadrao() {
        List<HorarioPadraoDTO> horarios = horarioPadraoService.buscarHorarios();
        return ResponseEntity.ok(horarios);
    }

    @GetMapping("/professor/horarios/ativos")
    public ResponseEntity<List<HorarioPadraoDTO>> listarHorarioAtivos() {
        List<HorarioPadraoDTO> horarios = horarioPadraoService.buscarHorariosAtivos();
            return ResponseEntity.ok(horarios);

    }

    @PutMapping("/admin/horarios/{id}/atualizar") // obrigatorio
    public ResponseEntity<HorarioPadraoModel> atualizarHorario(@PathVariable Integer id, @RequestBody HorarioPadraoDTO horarioPadraoDTO) {
        try{
            HorarioPadraoModel horarioAtualizado = horarioPadraoService.atualizarHorario(id, horarioPadraoDTO);
            return ResponseEntity.ok(horarioAtualizado);
        }catch(RuntimeException e){
            return ResponseEntity.notFound().build();
        }
    }
}
