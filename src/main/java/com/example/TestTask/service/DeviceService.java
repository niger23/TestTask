package com.example.TestTask.service;

import com.example.TestTask.model.*;
import com.example.TestTask.repository.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DeviceService {
    @Autowired
    private DeviceRepository deviceRepository;

    public Devices addDevices(Devices Devices) {
        return deviceRepository.save(Devices);
    }

    public Devices getDevices(Long id) {
        return deviceRepository.findById(id).orElse(null);
    }

    public List<Devices> getAllDevices() {
        return deviceRepository.findAll();
    }

    public Devices updateDevices(Long id, Devices updatedDevice) {
        return deviceRepository.findById(id)
                .map(Devices -> {
                    Devices.setName(updatedDevice.getName());
                    Devices.setCountry(updatedDevice.getCountry());
                    Devices.setCompany(updatedDevice.getCompany());
                    Devices.setOnlineOrder(updatedDevice.isOnlineOrder());
                    Devices.setInstalment(updatedDevice.isInstalment());
                    return deviceRepository.save(Devices);
                })
                .orElse(null);
    }

    public boolean deleteDevices(Long id) {
        if (deviceRepository.existsById(id)) {
            deviceRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Devices> getDevicesByCompany(String manufacturer) {
        return deviceRepository.findByCompany(manufacturer);
    }

    public List<Devices> getDevicesByCountry(String country) {
        return deviceRepository.findByCountry(country);
    }

    public List<Devices> getDevicesByOnlineOrder(boolean onlineOrder) {
        return deviceRepository.findByOnlineOrder(onlineOrder);
    }

    public List<Devices> getDevicesByInstalment(boolean instalmentPurchase) {
        return deviceRepository.findByInstalment(instalmentPurchase);
    }

}

