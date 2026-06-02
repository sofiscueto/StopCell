package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Ordem_Servico")
public class OrdemServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Num_Os")
    private Long numOs;

    @ManyToOne
    @JoinColumn(name = "Ordem_Servico_Num_Os")
    private OrdemServico ordemServicoPai;

    @ManyToOne
    @JoinColumn(name = "Cliente_Cpf", referencedColumnName = "Cpf", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "Aparelho_IMEI", referencedColumnName = "IMEI", nullable = false)
    private Aparelho aparelho;

    @ManyToOne
    @JoinColumn(name = "Empresa_Cnpj", referencedColumnName = "Cnpj", nullable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "usuario_idUsuario", nullable = false)
    private Usuario usuario;

    @Column(name = "Dt_Entrada")
    private LocalDateTime dtEntrada;

    @Column(name = "Dt_Saida")
    private LocalDateTime dtSaida;

    @Column(name = "Status", length = 50)
    private String status;

    @Column(name = "Vl_Total", precision = 10, scale = 2)
    private BigDecimal vlTotal;

    @Column(name = "Diagnostico", columnDefinition = "TEXT")
    private String diagnostico;
}