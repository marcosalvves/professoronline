package com.professoronline.msprofessor.service.impl;

// CORREÇÕES CRÍTICAS: Todos os imports agora apontam para os pacotes locais do ms-professor
import com.professoronline.msprofessor.dto.*;
import com.professoronline.msprofessor.model.Escola;
import com.professoronline.msprofessor.model.Professor;
import com.professoronline.msprofessor.model.Usuario;
import com.professoronline.msprofessor.repository.EscolaRepository;
import com.professoronline.msprofessor.repository.ProfessorRepository;
import com.professoronline.msprofessor.repository.UsuarioRepository;
import com.professoronline.msprofessor.service.ProfessorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfessorServiceImpl implements ProfessorService {

    private final ProfessorRepository professorRepository;
    private final UsuarioRepository usuarioRepository;
    private final EscolaRepository escolaRepository;

    public ProfessorServiceImpl(ProfessorRepository professorRepository,
                                UsuarioRepository usuarioRepository,
                                EscolaRepository escolaRepository) {
        this.professorRepository = professorRepository;
        this.usuarioRepository = usuarioRepository;
        this.escolaRepository = escolaRepository;
    }

    private ProfessorDTO converterParaDTO(Professor professor) {
        return new ProfessorDTO(professor);
    }

    private Professor converterParaEntidade(ProfessorDTO professorDTO) {

        Usuario usuario = usuarioRepository.findById(professorDTO.idUsuario())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        // Usamos o Repositório local da Escola, mas na arquitetura ideal seria um Feign Client.
        Escola escola = escolaRepository.findById(professorDTO.idEscola())
                .orElseThrow(() -> new RuntimeException("Escola não encontrada"));

        Professor professor = new Professor();

        professor.setIdUsuario(usuario);
        professor.setIdEscola(escola);
        professor.setRegistroProfessor(professorDTO.registroProfessor());
        professor.setStatusProfessor(professorDTO.statusProfessor() != null ? professorDTO.statusProfessor() : true);

        return professor;
    }

    @Override
    public ProfessorDTO salvar(ProfessorDTO professorDTO) {
        Professor professor = converterParaEntidade(professorDTO);
        return converterParaDTO(professorRepository.save(professor));
    }

    @Override
    public ProfessorDTO buscarPorId(Integer id) {
        return professorRepository.findById(id)
                .map(this::converterParaDTO)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));
    }

    @Override
    public List<ProfessorDTO> listarTodos() {
        return professorRepository.findAll()
                .stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProfessorDTO atualizarProfessor(Integer id, ProfessorDTO professorDTO) {
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado"));

        if (professorDTO.statusProfessor() != null) {
            professor.setStatusProfessor(professorDTO.statusProfessor());
        }

        if (professorDTO.registroProfessor() != null) {
            professor.setRegistroProfessor(professorDTO.registroProfessor());
        }

        return converterParaDTO(professorRepository.save(professor));
    }

    @Override
    public void deletarProfessor(Integer id) {
        professorRepository.deleteById(id);
    }

    @Override
    public ProfessorDTO atualizarStatus(Integer id, ProfessorStatusDTO dto){
        Professor professor = professorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Professor não encontrado com o ID: "+id));

        Usuario usuario = professor.getIdUsuario();

        professor.setStatusProfessor(dto.status());
        usuario.setStatus(dto.status());
        usuarioRepository.save(usuario);

        return converterParaDTO(professorRepository.save(professor));
    }

    @Override
    public List<ProfessorDTO> buscarProfessoresAtivos() {
        return professorRepository.findByStatusProfessor(true).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProfessorDTO> buscarProfessoresInativos(){
        return professorRepository.findByStatusProfessor(false).stream()
                .map(this::converterParaDTO)
                .collect(Collectors.toList());
    }

    // LÓGICA DESACOPLADA: Dependências externas (Turmas, Disciplinas) são substituídas por chamadas REST (Feign Client)
    // Aqui, retornamos listas vazias ou stubs, pois os dados não estão mais localmente
    @Override
    public PerfiProfessorDTO buscarPerfil(String nome) {
        Usuario usuarioDB = (Usuario) usuarioRepository.findByNome(nome);
        var professorDB = professorRepository.buscarPorIdUsuario(usuarioDB.getId())
                .orElseThrow(() -> new EntityNotFoundException("Professor não encontrado para o usuário."));

        // No ambiente real, chamadas Feign seriam feitas aqui para ms-escola
        // para obter 'disciplinas' e 'turmas'.

        // Formação Acadêmica é local (ms-professor), então podemos mapeá-la.
        var formacoesDTO = professorDB.getFormacoes().stream().map(FormacaoAcademicaDTO::new)
                .collect(Collectors.toUnmodifiableList());

        return new PerfiProfessorDTO(
                professorDB.getIdProfessor(),
                usuarioDB.getNome(),
                professorDB.getStatusProfessor(),
                Collections.emptyList(), // Disciplinas (ms-escola)
                formacoesDTO,            // Formações (ms-professor)
                Collections.emptyList()  // Turmas (ms-escola)
        );
    }
}