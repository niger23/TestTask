package com.example.TestTask.service;

import com.example.TestTask.model.Refrigerator;
import com.example.TestTask.repository.RefrigeratorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RefrigeratorService {
    @Autowired
    private final RefrigeratorRepository refrigeratorRepository;

    public Refrigerator addRefrigerator(Refrigerator refrigerator) {
        return refrigeratorRepository.save(refrigerator);
    }

    public Refrigerator getRefrigerator(Long id) {
        return refrigeratorRepository.findById(id).orElse(null);
    }

    public List<Refrigerator> getAllRefrigerators() {
        return refrigeratorRepository.findAll();
    }

    public Refrigerator updateRefrigerator(Long id, Refrigerator updatedRefrigerator) {
        return refrigeratorRepository.findById(id)
                .map(refrigerator -> {
                    refrigerator.setName(updatedRefrigerator.getName());
                    refrigerator.setSerialNumber(updatedRefrigerator.getSerialNumber());
                    refrigerator.setColor(updatedRefrigerator.getColor());
                    refrigerator.setSize(updatedRefrigerator.getSize());
                    refrigerator.setPrice(updatedRefrigerator.getPrice());
                    refrigerator.setAvailable(updatedRefrigerator.isAvailable());
                    refrigerator.setCompressorType(updatedRefrigerator.getCompressorType());
                    refrigerator.setNumberOfDoors(updatedRefrigerator.getNumberOfDoors());
                    return refrigeratorRepository.save(refrigerator);
                })
                .orElse(null);
    }

    public boolean deleteRefrigerator(Long id) {
        if (refrigeratorRepository.existsById(id)) {
            refrigeratorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Refrigerator> getRefrigeratorsByPriceRange(double minPrice, double maxPrice) {
        return refrigeratorRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Refrigerator> getAvailableRefrigerators() {
        return refrigeratorRepository.findByAvailable(true);
    }

    public List<Refrigerator> getRefrigeratorsByCompressorType(String compressor) {
        return refrigeratorRepository.findByCompressorType(compressor);
    }

    public List<Refrigerator> getRefrigeratorsByNumberOfDoors(int number) {
        return refrigeratorRepository.findByNumberOfDoors(number);
    }
}
