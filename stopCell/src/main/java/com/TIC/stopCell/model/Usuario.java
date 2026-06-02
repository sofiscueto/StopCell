package com.TIC.stopCell.model;

import com.TIC.stopCell.model.Empresa;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUsuario")
    private Long idUsuario;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_cnpj")
    private Empresa empresa;

    @Column(name = "Nome", length = 100)
    private String nome;

    @Column(name = "Login", length = 50)
    private String login;

    @Column(name = "email_usuario", length = 100)
    private String emailUsuario;

    @Column(name = "Senha", length = 255)
    private String senha;

    @Column(name = "Nivel_Acesso", length = 20)
    private String nivelAcesso;
}