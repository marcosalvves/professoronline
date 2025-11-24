package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "disponibilidade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DisponibilidadeModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_disponibilidade")
    private Integer id;

    @Column(name = "id_professor", nullable = false)
    private Integer idProfessor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_horario_padrao", nullable = false)
    private HorarioPadraoModel horarioPadraoModel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_semestre", nullable = false)
    private SemestreModel semestreModel;

}