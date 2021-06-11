package com.internetofthings.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.internetofthings.domain.DeviceInfo;

public interface InfoDeviceRepository extends JpaRepository<DeviceInfo, String> {
    List<DeviceInfo> findAllByDeviceType(String type);
}
