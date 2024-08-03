package com.example.TestTask.controller;

import com.example.TestTask.model.VacuumCleaner;
import com.example.TestTask.service.VacuumCleanerService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vacuum-cleaners")
public class VacuumCleanerController {
    @Autowired
    private final VacuumCleanerService vacuumCleanerService;

    @PostMapping
    public ResponseEntity<VacuumCleaner> addVacuumCleaner(@RequestBody VacuumCleaner vacuumCleaner) {
        VacuumCleaner createdVacuumCleaner = vacuumCleanerService.addVacuumCleaner(vacuumCleaner);
        return ResponseEntity.status(201).body(createdVacuumCleaner);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VacuumCleaner> getVacuumCleaner(@PathVariable Long id) {
        VacuumCleaner vacuumCleaner = vacuumCleanerService.getVacuumCleaner(id);
        return ResponseEntity.ok(vacuumCleaner);
    }

    @GetMapping
    public ResponseEntity<List<VacuumCleaner>> getAllVacuumCleaners() {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getAllVacuumCleaners();
        return ResponseEntity.ok(vacuumCleaners);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VacuumCleaner> updateVacuumCleaner(@PathVariable Long id, @RequestBody VacuumCleaner updatedVacuumCleaner) {
        VacuumCleaner updated = vacuumCleanerService.updateVacuumCleaner(id, updatedVacuumCleaner);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVacuumCleaner(@PathVariable Long id) {
        boolean deleted = vacuumCleanerService.deleteVacuumCleaner(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleanersByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getVacuumCleanersByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(vacuumCleaners);
    }

    @GetMapping("/available")
    public ResponseEntity<List<VacuumCleaner>> getAvailableVacuumCleaners() {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getAvailableVacuumCleaners();
        return ResponseEntity.ok(vacuumCleaners);
    }

    @GetMapping("/bag-volume")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleanersByBagVolume(@RequestParam double value) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getVacuumCleanersByBagVolume(value);
        return ResponseEntity.ok(vacuumCleaners);
    }

    @GetMapping("/number-modes")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleanersByNumberModes(@RequestParam int number) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getVacuumCleanersByNumberModes(number);
        return ResponseEntity.ok(vacuumCleaners);
    }

    @GetMapping("/size")
    public ResponseEntity<List<VacuumCleaner>> getVacuumCleanersBySize(@RequestParam int size) {
        List<VacuumCleaner> vacuumCleaners = vacuumCleanerService.getVacuumCleanersBySize(size);
        return ResponseEntity.ok(vacuumCleaners);
    }
}
