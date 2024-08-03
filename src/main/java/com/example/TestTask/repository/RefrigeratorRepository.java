package com.example.TestTask.repository;

import com.example.TestTask.model.Refrigerator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RefrigeratorRepository extends JpaRepository<Refrigerator, Long> {
    List<Refrigerator> findByPriceBetween(double minPrice, double maxPrice);
    List<Refrigerator> findByAvailable(boolean available);
    List<Refrigerator> findByNumberOfDoors(int number);
    List<Refrigerator> findByCompressorType(String compressorType);
}
