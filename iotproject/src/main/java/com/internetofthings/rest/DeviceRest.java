package com.internetofthings.rest;

import com.internetofthings.dto.DeviceResponse;
import com.internetofthings.dto.DeviceReceive;
import com.internetofthings.dto.DeviceResponseDTO;
import com.internetofthings.dto.Value;
import com.internetofthings.service.ReceiveDeviceDataService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "device")
public class DeviceRest {

    @Autowired
    private ReceiveDeviceDataService ReceiveDeviceDataService;


    @PostMapping("/data")
    @ApiOperation(
            value = "create/input data for IOT device",
            notes = "uses name manufacturer and type to check if the device already exists")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "CREATED"),
            @ApiResponse(code = 400, message = "", response = DeviceResponse.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponse.class)})
    public ResponseEntity<DeviceResponse> inputData(@Validated @RequestBody DeviceReceive request) {

        DeviceResponse result = ReceiveDeviceDataService.inputData(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping()
    @ApiOperation(
            value = "list devices registers",
            notes = "devices created")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 400, message = "", response = DeviceResponseDTO.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponseDTO.class)})
    public ResponseEntity<List<DeviceResponseDTO>> listDevice() {

        List<DeviceResponseDTO> result = ReceiveDeviceDataService.listDevices();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/data/{type}/history")
    @ApiOperation(
            value = "list devices data history",
            notes = "devices created")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 400, message = "", response = DeviceResponse.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponse.class)})
    public ResponseEntity<List<DeviceResponse>> historyDataType(@PathVariable("type") String type) {

        List<DeviceResponse> result = ReceiveDeviceDataService.history(type);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }


    @GetMapping("/data/{type}/average")
    @ApiOperation(
            value = "list devices registers",
            notes = "devices data created")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 400, message = "", response = Value.class),
            @ApiResponse(code = 500, message = "Error", response = Value.class)})
    public ResponseEntity<Value> averageData(@PathVariable("type") String type) {

        Value result = ReceiveDeviceDataService.findAverage(type);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @GetMapping("/data/{type}/max")
    @ApiOperation(
            value = "max value of  device data registered",
            notes = "max data of type created")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "SUCCESS"),
            @ApiResponse(code = 400, message = "", response = Value.class),
            @ApiResponse(code = 500, message = "Error", response = Value.class)})
    public ResponseEntity<Value> maxValue(@PathVariable("type") String type) {

        Value result = ReceiveDeviceDataService.findMaxValue(type);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

}
