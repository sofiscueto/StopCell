package com.TIC.stopCell.service;

import com.TIC.stopCell.model.ItensOs;
import com.TIC.stopCell.repository.ItemOSRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ItemOsService {
    @Autowired
    public ItemOSRepository itemOSRepository;

    public BigDecimal calcularSubtotal(Long id) {
        ItensOs item = itemOSRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        if (item.getQuantidade() == null || item.getValorUnitario() == null) {
            return BigDecimal.ZERO;
        }
        return item.getValorUnitario()
                .multiply(BigDecimal.valueOf(item.getQuantidade()));
    }
}
