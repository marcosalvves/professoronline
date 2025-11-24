package com.professoronline.msescola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "semestre")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SemestreModel {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id_semestre")
        private Integer id;

        @Column(name = "ano", nullable = false)
        private Integer ano;

        @Column(name = "periodo_ano", nullable = false)
        private String periodoAno;

        @Column(name = "status", nullable = false)
        private Boolean status = true;
}


