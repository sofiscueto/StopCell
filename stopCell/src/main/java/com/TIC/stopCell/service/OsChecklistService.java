package com.TIC.stopCell.service;

import com.TIC.stopCell.model.OsChecklist;
import com.TIC.stopCell.model.OsChecklist.OsChecklistId;

import com.TIC.stopCell.repository.OSChecklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OsChecklistService {

    @Autowired
    private OSChecklistRepository osChecklistRepository;

    public OsChecklist atualizarStatus(Long ordemServicoId, Long checklistId, String status) {
        OsChecklistId id = new OsChecklistId();
        id.setOrdemServico(ordemServicoId);
        id.setChecklist(checklistId);

        return osChecklistRepository.findById(id).map(osChecklist -> {
            osChecklist.setStatus(status);
            return osChecklistRepository.save(osChecklist);
        }).orElse(null);
    }
}
