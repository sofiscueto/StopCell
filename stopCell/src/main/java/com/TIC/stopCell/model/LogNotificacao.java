package com.TIC.stopCell.model;

import com.TIC.stopCell.model.Cliente;
import com.TIC.stopCell.model.OrdemServico;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "Log_Notificacao")
public class LogNotificacao  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idLog_Notificacao")
    private Long idLogNotificacao;

    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Ordem_Servico_Num_Os", nullable = false)
    private OrdemServico ordemServico;

    @ManyToOne
    @JoinColumn(name = "Cliente_Cpf", referencedColumnName = "Cpf", nullable = false)
    private Cliente cliente;

    @Column(name = "Tipo_Evento", length = 50)
    private String tipoEvento;

    @Column(name = "Dt_hora_envio")
    private LocalDateTime dtHoraEnvio;

    @Column(name = "Mensagem_texto", columnDefinition = "TEXT")
    private String mensagemTexto;

    @Column(name = "Status_Envio", length = 50)
    private String statusEnvio;
}