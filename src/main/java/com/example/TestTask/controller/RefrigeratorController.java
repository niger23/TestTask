package com.example.TestTask.controller;

import com.example.TestTask.model.Refrigerator;
import com.example.TestTask.service.RefrigeratorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/refrigerators")
public class RefrigeratorController {
    @Autowired
    private final RefrigeratorService refrigeratorService;

    @PostMapping
    public ResponseEntity<Refrigerator> addRefrigerator(@RequestBody Refrigerator refrigerator) {
        Refrigerator createdRefrigerator = refrigeratorService.addRefrigerator(refrigerator);
        return ResponseEntity.status(201).body(createdRefrigerator);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Refrigerator> getRefrigerator(@PathVariable Long id) {
        Refrigerator refrigerator = refrigeratorService.getRefrigerator(id);
        return ResponseEntity.ok(refrigerator);
    }

    @GetMapping
    public ResponseEntity<List<Refrigerator>> getAllRefrigerators() {
        List<Refrigerator> refrigerators = refrigeratorService.getAllRefrigerators();
        return ResponseEntity.ok(refrigerators);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Refrigerator> updateRefrigerator(@PathVariable Long id, @RequestBody Refrigerator updatedRefrigerator) {
        Refrigerator updated = refrigeratorService.updateRefrigerator(id, updatedRefrigerator);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRefrigerator(@PathVariable Long id) {
        boolean deleted = refrigeratorService.deleteRefrigerator(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Refrigerator>> getRefrigeratorsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Refrigerator> refrigerators = refrigeratorService.getRefrigeratorsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(refrigerators);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Refrigerator>> getAvailableRefrigerators() {
        List<Refrigerator> refrigerators = refrigeratorService.getAvailableRefrigerators();
        return ResponseEntity.ok(refrigerators);
    }

    @GetMapping("/doors")
    public ResponseEntity<List<Refrigerator>> getRefrigeratorsByNumberOfDoors(@RequestParam int number) {
        List<Refrigerator> refrigerators = refrigeratorService.getRefrigeratorsByNumberOfDoors(number);
        return ResponseEntity.ok(refrigerators);
    }


    @GetMapping("/compressor")
    public ResponseEntity<List<Refrigerator>> getRefrigeratorsByCompressorType(@RequestParam String compressor) {
        List<Refrigerator> refrigerators = refrigeratorService.getRefrigeratorsByCompressorType(compressor);
        return ResponseEntity.ok(refrigerators);
    }
}
