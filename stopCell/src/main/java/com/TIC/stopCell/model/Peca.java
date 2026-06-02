
package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
@Data
@Entity
@Table(name = "Peca")
public class Peca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPeca")
    private Long idPeca;

    @Column(name = "Descricao", length = 150)
    private String descricao;

    @Column(name = "Valor", precision = 10, scale = 2)
    private BigDecimal valor;

    @Column(name = "Quantidade")
    private Integer quantidade;
}