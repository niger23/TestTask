package com.example.TestTask.controller;

import com.example.TestTask.model.Smartphone;
import com.example.TestTask.service.SmartphoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/smartphones")
public class SmartphoneController {
    @Autowired
    private final SmartphoneService smartphoneService;

    @PostMapping
    public ResponseEntity<Smartphone> addSmartphone(@RequestBody Smartphone smartphone) {
        Smartphone createdSmartphone = smartphoneService.addSmartphone(smartphone);
        return ResponseEntity.status(201).body(createdSmartphone);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Smartphone> getSmartphone(@PathVariable Long id) {
        Smartphone smartphone = smartphoneService.getSmartphone(id);
        return ResponseEntity.ok(smartphone);
    }

    @GetMapping
    public ResponseEntity<List<Smartphone>> getAllSmartphones() {
        List<Smartphone> smartphones = smartphoneService.getAllSmartphones();
        return ResponseEntity.ok(smartphones);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Smartphone> updateSmartphone(@PathVariable Long id, @RequestBody Smartphone updatedSmartphone) {
        Smartphone updated = smartphoneService.updateSmartphone(id, updatedSmartphone);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSmartphone(@PathVariable Long id) {
        boolean deleted = smartphoneService.deleteSmartphone(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<Smartphone>> getSmartphonesByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<Smartphone> smartphones = smartphoneService.getSmartphonesByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(smartphones);
    }

    @GetMapping("/available")
    public ResponseEntity<List<Smartphone>> getAvailableSmartphones() {
        List<Smartphone> smartphones = smartphoneService.getAvailableSmartphones();
        return ResponseEntity.ok(smartphones);
    }

    @GetMapping("/memory")
    public ResponseEntity<List<Smartphone>> getSmartphonesByMemory(@RequestParam int memory) {
        List<Smartphone> smartphones = smartphoneService.getSmartphonesByMemory(memory);
        return ResponseEntity.ok(smartphones);
    }

    @GetMapping("/cameras")
    public ResponseEntity<List<Smartphone>> getSmartphonesByNumberOfCameras(@RequestParam int number) {
        List<Smartphone> smartphones = smartphoneService.getSmartphonesByNumberOfCameras(number);
        return ResponseEntity.ok(smartphones);
    }
}
