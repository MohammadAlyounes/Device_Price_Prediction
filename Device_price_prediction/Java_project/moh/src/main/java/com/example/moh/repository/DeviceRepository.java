package com.example.moh.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.moh.model.Device;


public interface DeviceRepository extends JpaRepository<Device, Long> {
}
