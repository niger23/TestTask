package com.example.TestTask.repository;

import com.example.TestTask.model.Smartphone;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SmartphoneRepository extends JpaRepository<Smartphone, Long> {
    List<Smartphone> findByPriceBetween(double minPrice, double maxPrice);
    List<Smartphone> findByAvailable(boolean available);
    List<Smartphone> findByMemory(int memory);
    List<Smartphone> findByNumberOfCameras(int number);
}
