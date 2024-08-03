package com.example.TestTask.repository;

import com.example.TestTask.model.VacuumCleaner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VacuumCleanerRepository extends JpaRepository<VacuumCleaner, Long> {
    List<VacuumCleaner> findByPriceBetween(double minPrice, double maxPrice);
    List<VacuumCleaner> findByAvailable(boolean available);
    List<VacuumCleaner> findByDustBagVolume(double value);
    List<VacuumCleaner> findByNumberOfModes(int number);
    List<VacuumCleaner> findBySize(int size);
}
