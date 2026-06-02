package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "cliente")
public class Cliente {

    @Id
    @Column(name = "Cpf", length = 11)
    private String cpf;

    @Column(name = "Nm_completo", length = 100)
    private String nmCompleto;

    @Column(name = "Telefone", length = 20)
    private String telefone;

    @Column(name = "Email", length = 100)
    private String email;

    @Column(name = "Endereco", length = 150)
    private String endereco;
}