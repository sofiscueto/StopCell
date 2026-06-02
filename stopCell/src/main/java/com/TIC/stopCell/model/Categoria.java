package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_categoria")
    private Long idCategoria;

    @Column(name = "Nm_categoria", length = 100)
    private String nmCategoria;
}