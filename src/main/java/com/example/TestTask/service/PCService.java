package com.example.TestTask.service;

import com.example.TestTask.model.PC;
import com.example.TestTask.repository.PCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PCService {
    @Autowired
    private final PCRepository pcRepository;

    public PC addPC(PC pc) {
        return pcRepository.save(pc);
    }

    public PC getPC(Long id) {
        return pcRepository.findById(id).orElse(null);
    }

    public List<PC> getAllPCs() {
        return pcRepository.findAll();
    }

    public PC updatePC(Long id, PC updatedPC) {
        return pcRepository.findById(id)
                .map(pc -> {
                    pc.setName(updatedPC.getName());
                    pc.setSerialNumber(updatedPC.getSerialNumber());
                    pc.setColor(updatedPC.getColor());
                    pc.setSize(updatedPC.getSize());
                    pc.setPrice(updatedPC.getPrice());
                    pc.setAvailable(updatedPC.isAvailable());
                    pc.setProcessorType(updatedPC.getProcessorType());
                    pc.setCategory(updatedPC.getCategory());
                    return pcRepository.save(pc);
                })
                .orElse(null);
    }

    public boolean deletePC(Long id) {
        if (pcRepository.existsById(id)) {
            pcRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<PC> getPCsByPriceRange(double minPrice, double maxPrice) {
        return pcRepository.findByPriceBetween(minPrice, maxPrice);
    }

    public List<PC> getAvailablePCs() {
        return pcRepository.findByAvailable(true);
    }

    public List<PC> getPCsByCategory(String category) {
        return pcRepository.findByCategory(category);
    }

    public List<PC> getPCsByProcessor(String processor) {
        return pcRepository.findByProcessorType(processor);
    }


}
