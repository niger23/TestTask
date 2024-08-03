package com.example.TestTask.controller;

import com.example.TestTask.model.TV;
import com.example.TestTask.service.TVService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/tvs")
public class TVController {
    @Autowired
    private final TVService tvService;

    @PostMapping
    public ResponseEntity<TV> addTV(@RequestBody TV tv) {
        TV createdTV = tvService.addTV(tv);
        return ResponseEntity.status(201).body(createdTV);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TV> getTV(@PathVariable Long id) {
        TV tv = tvService.getTV(id);
        return ResponseEntity.ok(tv);
    }

    @GetMapping
    public ResponseEntity<List<TV>> getAllTVs() {
        List<TV> tvs = tvService.getAllTVs();
        return ResponseEntity.ok(tvs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TV> updateTV(@PathVariable Long id, @RequestBody TV updatedTV) {
        TV updated = tvService.updateTV(id, updatedTV);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTV(@PathVariable Long id) {
        boolean deleted = tvService.deleteTV(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/price-range")
    public ResponseEntity<List<TV>> getTVsByPriceRange(@RequestParam double minPrice, @RequestParam double maxPrice) {
        List<TV> tvs = tvService.getTVsByPriceRange(minPrice, maxPrice);
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/available")
    public ResponseEntity<List<TV>> getAvailableTVs() {
        List<TV> tvs = tvService.getAvailableTVs();
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/category")
    public ResponseEntity<List<TV>> getTVsByCategory(@RequestParam String category) {
        List<TV> tvs = tvService.getTVsByCategory(category);
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/size")
    public ResponseEntity<List<TV>> getTVsBySize(@RequestParam int size) {
        List<TV> tvs = tvService.getTVsBySize(size);
        return ResponseEntity.ok(tvs);
    }

    @GetMapping("/technology")
    public ResponseEntity<List<TV>> getTVsByTechnology(@RequestParam String technology) {
        List<TV> tvs = tvService.getTVsByTechnology(technology);
        return ResponseEntity.ok(tvs);
    }
}

