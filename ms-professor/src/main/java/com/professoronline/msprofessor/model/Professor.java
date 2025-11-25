package com.professoronline.msprofessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

import static jakarta.persistence.GenerationType.*;

@Entity
@Table(name = "professor")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Professor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_professor")
    private Integer idProfessor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_usuario", nullable = false)
    private Usuario idUsuario;

    // MANTIDO TEMPORARIAMENTE: A relação com Escola ainda existe no modelo.
    // O próximo passo seria transformá-lo em 'private Integer idEscola;'.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_escola", nullable = false)
    private Escola idEscola;

    @Column(name = "registro_professor", length = 50, unique = true, nullable = false)
    private String registroProfessor;

    @Column(name = "status_professor", nullable = false)
    private Boolean statusProfessor = true;

    // MANTIDO: Formação Acadêmica é parte do domínio Professor.
    @OneToMany(mappedBy = "idProfessor", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FormacaoAcademica> formacoes;

    // REMOVIDAS as referências a Turma, ProfessorDisciplina e Disponibilidade.
    // Estes dados serão obtidos via comunicação inter-microsserviços (Feign/REST).

    public String getNome(){
        return this.idUsuario != null ? this.idUsuario.getNome() : null;
    }
}