package com.example.TestTask.service;

import com.example.TestTask.model.VacuumCleaner;
import com.example.TestTask.repository.VacuumCleanerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VacuumCleanerService {
    @Autowired
    private final VacuumCleanerRepository vacuumCleanerRepository;

    public VacuumCleaner addVacuumCleaner(VacuumCleaner vacuumCleaner) {
        return vacuumCleanerRepository.save(vacuumCleaner);
    }

    public VacuumCleaner getVacuumCleaner(Long id) {
        return vacuumCleanerRepository.findById(id).orElse(null);
    }

    public List<VacuumCleaner> getAllVacuumCleaners() {
        return vacuumCleanerRepository.findAll();
    }

    public VacuumCleaner updateVacuumCleaner(Long id, VacuumCleaner updatedVacuumCleaner) {
        return vacuumCleanerRepository.findById(id)
                .map(vacuumCleaner -> {
                    vacuumCleaner.setName(updatedVacuumCleaner.getName());
                    vacuumCleaner.setSerialNumber(updatedVacuumCleaner.getSerialNumber());
                    vacuumCleaner.setColor(updatedVacuumCleaner.getColor());
                    vacuumCleaner.setSize(updatedVacuumCleaner.getSize());
                    vacuumCleaner.setPrice(updatedVacuumCleaner.getPrice());
                    vacuumCleaner.setAvailable(updatedVacuumCleaner.isAvailable());
                    vacuumCleaner.setDustBagVolume(updatedVacuumCleaner.getDustBagVolume());
                    vacuumCleaner.setNumberOfModes(updatedVacuumCleaner.getNumberOfModes());
                    return vacuumCleanerRepository.save(vacuumCleaner);
                })
                .orElse(null);
    }

    public boolean deleteVacuumCleaner(Long id) {
        if (vacuumCleanerRepository.existsById(id)) {
            vacuumCleanerRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<VacuumCleaner> getVacuumCleanersByPriceRange(double minPrice, double maxPrice) {
        return vacuumCleanerRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<VacuumCleaner> getAvailableVacuumCleaners() {
        return vacuumCleanerRepository.findByAvailable(true);
    }

    public List<VacuumCleaner> getVacuumCleanersByBagVolume(double value) {
        return vacuumCleanerRepository.findByDustBagVolume(value);
    }

    public List<VacuumCleaner> getVacuumCleanersBySize(int size) {
        return vacuumCleanerRepository.findBySize(size);
    }

    public List<VacuumCleaner> getVacuumCleanersByNumberModes(int number) {
        return vacuumCleanerRepository.findByNumberOfModes(number);
    }

}
