package com.TIC.stopCell.model;

import com.TIC.stopCell.model.Categoria;
import com.TIC.stopCell.model.Cliente;
import com.TIC.stopCell.model.Marca;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "aparelho")
public class Aparelho  {

    @Id
    @Column(name = "imei", length = 50)
    private String imei;

    @ManyToOne
    @JoinColumn(name = "categoria_id_categoria", nullable = false)
    private Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "marca_id_marca", nullable = false)
    private Marca marca;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf", nullable = false)
    private Cliente cliente;

    @Column(name = "modelo", length = 100)
    private String modelo;

    @Column(name = "cor", length = 50)
    private String cor;

    @Column(name = "senha_aparelho", length = 255)
    private String senhaAparelho;

    @Column(name = "tipo_senha", length = 50)
    private String tipoSenha;
}