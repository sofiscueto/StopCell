package com.TIC.stopCell.controller;

import com.TIC.stopCell.service.ItemOsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequestMapping("/itemOs")
public class ItemOsController {
    @Autowired
    private ItemOsService itemOsService;
    @GetMapping("/{id}/subtotal")
    public ResponseEntity<BigDecimal> calcularSubtotal(@PathVariable Long id) {
        BigDecimal subtotal = itemOsService.calcularSubtotal(id);
        return ResponseEntity.ok(subtotal);
    }

}
