package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable {

    @Id
    @Column(name = "Cnpj", length = 14)
    private String cnpj;

    @Column(name = "Nome_Fantasia", length = 100)
    private String nomeFantasia;

    @Column(name = "Razao_Social", length = 100)
    private String razaoSocial;

    @Column(name = "Telefone", length = 20)
    private String telefone;

    @Column(name = "Endereco", length = 150)
    private String endereco;
}