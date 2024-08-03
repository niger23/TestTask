package com.example.TestTask.repository;

import com.example.TestTask.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Devices, Long> {
    List<Devices> findByCompany(String manufacturer);
    List<Devices> findByCountry(String country);
    List<Devices> findByOnlineOrder(boolean onlineOrder);
    List<Devices> findByInstalment(boolean instalmentPurchase);
}

