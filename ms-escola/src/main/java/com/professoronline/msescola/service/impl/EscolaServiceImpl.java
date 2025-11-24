package com.professoronline.msescola.service.impl;

import com.professoronline.msescola.dto.EscolaDTO;
import com.professoronline.msescola.dto.EscolaStatusDTO;
import com.professoronline.msescola.model.EscolaModel;
import com.professoronline.msescola.repository.EscolaRepository;
import com.professoronline.msescola.service.EscolaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EscolaServiceImpl implements EscolaService {

    private final EscolaRepository escolaRepository;

    public EscolaServiceImpl(EscolaRepository escolaRepository) {
        this.escolaRepository = escolaRepository;
    }

    public EscolaModel toEntity(EscolaDTO escolaDTO) {
        EscolaModel escola = new EscolaModel();
        escola.setNome(escolaDTO.nome());
        escola.setStatus(true);
        return escola;
    }

    public void criarEscola(EscolaDTO escolaDTO) {
        EscolaModel escolaEntity = toEntity(escolaDTO);
        escolaRepository.save(escolaEntity);
    }

    public EscolaModel buscarPorId(Integer id) {
        return escolaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com o ID: " + id));
    }

    public void atualizarEscola(Integer id, EscolaDTO escolaDTO) {
        EscolaModel escolaEntity = buscarPorId(id);
        escolaEntity.setNome(escolaDTO.nome());
        escolaEntity.setStatus(escolaDTO.status());
        escolaRepository.save(escolaEntity);
    }

    public void atualizarStatus(Integer id, EscolaStatusDTO status) {
        EscolaModel escolaEncontrada = buscarPorId(id);
        Boolean statusRecebido = status.status();
        escolaEncontrada.setStatus(statusRecebido);
        escolaRepository.save(escolaEncontrada);
    }

    public List<EscolaModel> listarEscolas() {
        return escolaRepository.findAll();
    }

    @Override
    public void deletarEscolas(Integer id) {

    }

    /*
    public void deletarEscolas(Integer id) {
        try {

            escolaRepository.deleteById(id);
        }catch (DataIntegrityViolationException e){
            throw new RelacionamentoEntidadeException("Não é possível excluir: existem registros relacionados.");
        }
    }
*/

}
