package com.professoronline.msprofessor.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tipo_categoria")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoCategoria {
    @Id
    @Column(name = "id_tipo_categoria")
    private Integer id;

    @Column(name = "nome_categoria", nullable = false, length = 100)
    private String nome_categoria;
}