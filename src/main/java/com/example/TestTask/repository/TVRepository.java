package com.example.TestTask.repository;

import com.example.TestTask.model.TV;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TVRepository extends JpaRepository<TV, Long> {
    List<TV> findByPriceBetween(double minPrice, double maxPrice);
    List<TV> findByAvailable(boolean available);
    List<TV> findBySize(int size);
    List<TV> findByCategory(String category);
    List<TV> findByTechnology(String technology);
}
