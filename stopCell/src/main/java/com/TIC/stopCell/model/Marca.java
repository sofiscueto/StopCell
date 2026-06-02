

package com.TIC.stopCell.model;

import jakarta.persistence.*;
import lombok.Data;



@Data
@Entity
@Table(name = "Marca")
public class Marca  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marca")
    private Long idMarca;

    @Column(name = "Nm_marca", length = 100)
    private String nmMarca;
}