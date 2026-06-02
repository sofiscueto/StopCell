package com.TIC.stopCell.model;


import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Data
@Entity
@Table(name = "Itens_Os")
public class ItensOs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idItem_Os")
    private Long idItemOs;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Ordem_Servico_Num_Os", nullable = false)
    private OrdemServico ordemServico;

    @ManyToOne
    @JoinColumn(name = "Servico_idServico")
    private Servico servico;

    @ManyToOne
    @JoinColumn(name = "Peca_idPeca")
    private Peca peca;

    @Column(name = "Quantidade")
    private Integer quantidade;

    @Column(name = "Valor_Unitario", precision = 10, scale = 2)
    private BigDecimal valorUnitario;
}
 