package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Diagnostico")
public class Diagnostico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iddiagnostico")
    private Long idDiagnostico;

    @ManyToOne(optional = false)
    @JoinColumn(name = "ordem_servico_num_os", nullable = false)
    private OrdemServico ordemServico;


    @Column(name = "relato_tecnico", columnDefinition = "TEXT")
    private String relatoTecnico;

    @Column(name = "data_hora")
    private LocalDateTime dataHora;
}