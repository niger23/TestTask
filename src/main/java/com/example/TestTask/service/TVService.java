package com.example.TestTask.service;

import com.example.TestTask.model.TV;
import com.example.TestTask.repository.TVRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TVService {
    @Autowired
    private final TVRepository tvRepository;

    public TV addTV(TV tv) {
        return tvRepository.save(tv);
    }

    public TV getTV(Long id) {
        return tvRepository.findById(id).orElse(null);
    }

    public List<TV> getAllTVs() {
        return tvRepository.findAll();
    }

    public TV updateTV(Long id, TV updatedTV) {
        return tvRepository.findById(id)
                .map(tv -> {
                    tv.setName(updatedTV.getName());
                    tv.setSerialNumber(updatedTV.getSerialNumber());
                    tv.setColor(updatedTV.getColor());
                    tv.setSize(updatedTV.getSize());
                    tv.setPrice(updatedTV.getPrice());
                    tv.setAvailable(updatedTV.isAvailable());
                    tv.setCategory(updatedTV.getCategory());
                    tv.setTechnology(updatedTV.getTechnology());
                    return tvRepository.save(tv);
                })
                .orElse(null);
    }

    public boolean deleteTV(Long id) {
        if (tvRepository.existsById(id)) {
            tvRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<TV> getTVsByPriceRange(double minPrice, double maxPrice) {
        return tvRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<TV> getAvailableTVs() {
        return tvRepository.findByAvailable(true);
    }

    public List<TV> getTVsByCategory(String category) {
        return tvRepository.findByCategory(category);
    }

    public List<TV> getTVsBySize(int size) {
        return tvRepository.findBySize(size);
    }

    public List<TV> getTVsByTechnology(String technology) {
        return tvRepository.findByTechnology(technology);
    }
}
