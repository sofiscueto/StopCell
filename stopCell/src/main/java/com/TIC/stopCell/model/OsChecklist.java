package com.TIC.stopCell.model;

import com.TIC.stopCell.model.OrdemServico;
import jakarta.persistence.*;
import lombok.Data;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Os_Checklist")
@IdClass(OsChecklist.OsChecklistId.class)
public class OsChecklist {

    @Id
    @ManyToOne(cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "Ordem_Servico_Num_Os", nullable = false)
    private OrdemServico ordemServico;

    @Id
    @ManyToOne
    @JoinColumn(name = "Checklist_idChecklist", nullable = false)
    private Checklist checklist;

    @Column(name = "Status", length = 20)
    private String status;

    @Data
    public static class OsChecklistId implements Serializable {
        private Long ordemServico;
        private Long checklist;
    }
}