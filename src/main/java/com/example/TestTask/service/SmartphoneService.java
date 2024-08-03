package com.example.TestTask.service;

import com.example.TestTask.model.Smartphone;
import com.example.TestTask.repository.SmartphoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SmartphoneService {
    @Autowired
    private final SmartphoneRepository smartphoneRepository;

    public Smartphone addSmartphone(Smartphone smartphone) {
        return smartphoneRepository.save(smartphone);
    }

    public Smartphone getSmartphone(Long id) {
        return smartphoneRepository.findById(id).orElse(null);
    }

    public List<Smartphone> getAllSmartphones() {
        return smartphoneRepository.findAll();
    }

    public Smartphone updateSmartphone(Long id, Smartphone updatedSmartphone) {
        return smartphoneRepository.findById(id)
                .map(smartphone -> {
                    smartphone.setName(updatedSmartphone.getName());
                    smartphone.setSerialNumber(updatedSmartphone.getSerialNumber());
                    smartphone.setColor(updatedSmartphone.getColor());
                    smartphone.setSize(updatedSmartphone.getSize());
                    smartphone.setPrice(updatedSmartphone.getPrice());
                    smartphone.setAvailable(updatedSmartphone.isAvailable());
                    smartphone.setMemory(updatedSmartphone.getMemory());
                    smartphone.setNumberOfCameras(updatedSmartphone.getNumberOfCameras());
                    return smartphoneRepository.save(smartphone);
                })
                .orElse(null);
    }

    public boolean deleteSmartphone(Long id) {
        if (smartphoneRepository.existsById(id)) {
            smartphoneRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Smartphone> getSmartphonesByPriceRange(double minPrice, double maxPrice) {
        return smartphoneRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<Smartphone> getAvailableSmartphones() {
        return smartphoneRepository.findByAvailable(true);
    }

    public List<Smartphone> getSmartphonesByMemory(int memory) {
        return smartphoneRepository.findByMemory(memory);
    }

    public List<Smartphone> getSmartphonesByNumberOfCameras(int number) {
        return smartphoneRepository.findByNumberOfCameras(number);
    }
}
