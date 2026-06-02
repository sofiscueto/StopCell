package com.TIC.stopCell.controller;

import com.TIC.stopCell.model.OsChecklist;
import com.TIC.stopCell.service.OsChecklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/osChecklist")
public class OsChecklistController {

    @Autowired
    private OsChecklistService osChecklistService;

    @PatchMapping("/{ordemServicoId}/{checklistId}/status")
    public ResponseEntity<OsChecklist> atualizarStatus(
            @PathVariable Long ordemServicoId,
            @PathVariable Long checklistId,
            @RequestParam String status) {
        OsChecklist resposta = osChecklistService.atualizarStatus(ordemServicoId, checklistId, status);
        if (resposta != null) {
            return ResponseEntity.ok(resposta);
        }
        return ResponseEntity.notFound().build();
    }
}
