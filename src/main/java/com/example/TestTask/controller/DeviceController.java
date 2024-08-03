package com.example.TestTask.controller;

import com.example.TestTask.model.*;
import com.example.TestTask.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/devices")
public class DeviceController {
    @Autowired
    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Devices> addDevices(@RequestBody Devices devices) {
        Devices createdDevices = deviceService.addDevices(devices);
        return ResponseEntity.status(201).body(createdDevices);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Devices> getDevices(@PathVariable Long id) {
        Devices Devices = deviceService.getDevices(id);
        return ResponseEntity.ok(Devices);
    }

    @GetMapping
    public ResponseEntity<List<Devices>> getAllDevices() {
        List<Devices> Devices = deviceService.getAllDevices();
        return ResponseEntity.ok(Devices);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Devices> updateDevices(@PathVariable Long id, @RequestBody Devices updatedDevices) {
        Devices updated = deviceService.updateDevices(id, updatedDevices);
        if (updated != null) {
            return ResponseEntity.ok(updated);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevices(@PathVariable Long id) {
        boolean deleted = deviceService.deleteDevices(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/company")
    public ResponseEntity<List<Devices>> getDevicesByCompany(@RequestParam String manufacturer) {
        List<Devices> Devices = deviceService.getDevicesByCompany(manufacturer);
        return ResponseEntity.ok(Devices);
    }

    @GetMapping("/country")
    public ResponseEntity<List<Devices>> getDevicesByCountry(@RequestParam String country) {
        List<Devices> Devices = deviceService.getDevicesByCountry(country);
        return ResponseEntity.ok(Devices);
    }

    @GetMapping("/online-order")
    public ResponseEntity<List<Devices>> getDevicesByOnlineOrder(@RequestParam boolean onlineOrder) {
        List<Devices> Devices = deviceService.getDevicesByOnlineOrder(onlineOrder);
        return ResponseEntity.ok(Devices);
    }

    @GetMapping("/installment")
    public ResponseEntity<List<Devices>> getDevicesByInstalment(@RequestParam boolean instalment) {
        List<Devices> Devices = deviceService.getDevicesByInstalment(instalment);
        return ResponseEntity.ok(Devices);
    }
}
