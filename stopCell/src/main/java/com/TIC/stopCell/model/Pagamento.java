package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Pagamento")
public class Pagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPagamento")
    private Long idPagamento;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Ordem_Servico_Num_Os", nullable = false)
    private OrdemServico ordemServico;

    @Column(name = "Valor_pago", precision = 10, scale = 2)
    private BigDecimal valorPago;

    @Column(name = "Dt_pagamento")
    private LocalDateTime dtPagamento;

    @Column(name = "Forma_pagamento", length = 50)
    private String formaPagamento;
}