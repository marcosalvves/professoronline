package com.professoronline.msprofessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@Table(name = "formacao_academica")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormacaoAcademica {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id_formacao_academica")
    private Integer idFormacaoAcademica;

    // Relação com Professor (a própria entidade deste MS)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", nullable = false)
    private Professor idProfessor;

    // Relação com TipoCategoria
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipo_categoria", nullable = false)
    private TipoCategoria idTipoCategoria;

    @Column(name = "nome_curso", nullable = false, length = 150)
    private String nomeCurso;

    @Column(name = "nome_instituicao_formacao", nullable = false, length = 150)
    private String nomeInstituicaoFormacao;

    @Column(name = "ano_conclusao",  nullable = false)
    private Integer anoConclusao;

    // Método auxiliar para atualização (observado no código original)
    public FormacaoAcademica atualizar(FormacaoAcademica formacaoAcademica){
        this.anoConclusao = formacaoAcademica.anoConclusao;
        this.nomeCurso = formacaoAcademica.nomeCurso;
        this.nomeInstituicaoFormacao = formacaoAcademica.getNomeInstituicaoFormacao();

        return  this;
    }
}