package com.example.TestTask.repository;

import com.example.TestTask.model.PC;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PCRepository extends JpaRepository<PC, Long> {
    List<PC> findByPriceBetween(double minPrice, double maxPrice);
    List<PC> findByAvailable(boolean available);
    List<PC> findByCategory(String category);
    List<PC> findByProcessorType(String processor);
}
