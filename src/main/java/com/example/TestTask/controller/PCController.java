package com.example.TestTask.controller;

import com.example.TestTask.model.PC;
import com.example.TestTask.service.PCService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/pcs")
public class PCController {
    @Autowired
    private final PCService pcService;

    @PostMapping
    public ResponseEntity<PC> addPC(@RequestBody PC pc) {
        PC createdPC = pcService.addPC(pc);
        return ResponseEntity.status(201).body(createdPC);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PC> getPC(@PathVariable Long id) {
        PC pc = pcService.getPC(id);
        return ResponseEntity.ok(pc);
    }

    @GetMapping
    public ResponseEntity<List<PC>> getAllPCs() {
        List<PC> pcs = pcService.getAllPCs();
        return ResponseEntity.ok(pcs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PC> updatePC(@PathVariable Long id, @RequestBody PC updatedPC) {
        PC updated = pcService.updatePC(id, updatedPC);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePC(@PathVariable Long id) {
        boolean deleted = pcService.deletePC(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<PC>> getPCsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<PC> pcs = pcService.getPCsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(pcs);
    }

    @GetMapping("/available")
    public ResponseEntity<List<PC>> getAvailablePCs() {
        List<PC> pcs = pcService.getAvailablePCs();
        return ResponseEntity.ok(pcs);
    }

    @GetMapping("/category")
    public ResponseEntity<List<PC>> getPCsByCategory(@RequestParam String category) {
        List<PC> pcs = pcService.getPCsByCategory(category);
        return ResponseEntity.ok(pcs);
    }

    @GetMapping("/processor")
    public ResponseEntity<List<PC>> getPCsByProcessor(@RequestParam String processor) {
        List<PC> pcs = pcService.getPCsByProcessor(processor);
        return ResponseEntity.ok(pcs);
    }

}
