package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Entity
@Table(name = "horario_padrao")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioPadraoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_horario_padrao", unique = true)
    private Integer id;

    @Column(name = "turno", nullable = false, length = 50)
    private String turno;

    @Column(name = "hora_inicio", nullable = false)
    private LocalTime hora_inicio;

    @Column(name = "hora_fim", nullable = false)
    private LocalTime hora_fim;

    @Column(name = "ativo", nullable = false)
    private Boolean ativo;

    @Column(name = "dia_semana", nullable = false,length = 20)
    private String dia_semana;
}