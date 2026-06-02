package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "Checklist")
public class Checklist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idchecklist")
    private Long idChecklist;

    @Column(name = "descricao", length = 100)
    private String descricao;

}