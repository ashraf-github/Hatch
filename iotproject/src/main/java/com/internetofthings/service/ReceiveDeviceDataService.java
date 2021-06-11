package com.internetofthings.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.internetofthings.domain.Device;
import com.internetofthings.domain.DeviceInfo;
import com.internetofthings.dto.DeviceReceive;
import com.internetofthings.dto.DeviceResponse;
import com.internetofthings.dto.DeviceResponseDTO;
import com.internetofthings.dto.Value;
import com.internetofthings.repository.DeviceRepository;
import com.internetofthings.repository.InfoDeviceRepository;


@Component
public class ReceiveDeviceDataService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Autowired
    private InfoDeviceRepository InfoDeviceRepository;


    public DeviceResponse inputData(DeviceReceive request) {

        Optional<Device> deviceOpt = deviceRepository.findByNameAndManufacturerAndType(request.getName(), request.getManufacturer(), request.getType());

        Device device = deviceOpt.orElseGet(() -> deviceRepository.save(new Device(1L, request.getManufacturer(), request.getType(),null,null)));
        DeviceInfo data = InfoDeviceRepository.save(new DeviceInfo(device, request.getValue()));
        DeviceResponse response = new DeviceResponse();
        return response;
    }

    public List<DeviceResponseDTO> listDevices() {

        List<Device> devices = deviceRepository.findAll();

        return devices.stream().map(device -> new DeviceResponseDTO(device.getDeviceId(), device.getDeviceName(), device.getDeviceFactory(), device.getDeviceType())).collect(Collectors.toList());
    }

    public List<DeviceResponse> history(String type) {

        return InfoDeviceRepository.findAllByDeviceType(type).stream().map(data -> new DeviceResponse(Long.valueOf(data.getDevice().toString()), data.getId(), data.getValue(), data.getCreatedAt())).collect(Collectors.toList());
    }

    public Value findAverage(String type) {
        return new Value(InfoDeviceRepository.findAllByDeviceType(type).stream().mapToDouble(data -> new Double(data.getValue()).doubleValue()).average().getAsDouble());

    }

    public Value findMaxValue(String type) {
        return new Value(InfoDeviceRepository.findAllByDeviceType(type).stream().mapToDouble(data -> new Double(data.getValue()).doubleValue()).max().getAsDouble());

    }
}
