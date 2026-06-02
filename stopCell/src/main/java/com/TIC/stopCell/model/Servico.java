
package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;


import java.math.BigDecimal;
@Data
@Entity
@Table(name = "Servico")
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idServico")
    private Long idServico;

    @Column(name = "Descricao", length = 150)
    private String descricao;

    @Column(name = "Valor", precision = 10, scale = 2)
    private BigDecimal valor;
}