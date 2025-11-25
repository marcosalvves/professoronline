package com.professoronline.msprofessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "escola")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Escola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_escola")
    private Integer id;

    @Column(name = "nome", nullable = false, length = 150)
    private String nome;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @Column(name = "criacao_date", nullable = false)
    private LocalDate criacaoDate;
}