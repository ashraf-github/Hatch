package com.internetofthings.rest;

import com.internetofthings.dto.DeviceResponse;
import com.internetofthings.iots.PulseCalculator;
import com.internetofthings.iots.VelocityCalculator;
import com.internetofthings.iots.HomeVoice;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "iot")
public class IotRest {

    @Autowired
    private PulseCalculator PulseCalculator;

    @Autowired
    private VelocityCalculator VelocityCalculator;

    @Autowired
    private HomeVoice HomeVoice;


    @PostMapping("/start/{iotType}")
    @ApiOperation(
            value = "start IOT to send data",
            notes = "start thread")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "ACCEPTED"),
            @ApiResponse(code = 400, message = "", response = DeviceResponse.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponse.class)})
    public ResponseEntity<String> start(@PathVariable("iotType") @ApiParam(name = "iotType", value = "type of IOT managed",
            allowableValues = "PulseCalculator,VelocityCalculator,HomeVoice", required = true) String type) {

        switch (type) {
            case "PulseCalculator":
                PulseCalculator.startDeviceExecution();
                break;
            case "VelocityCalculator":
                VelocityCalculator.startDeviceExecution();
                break;
            case "HomeVoice":
                HomeVoice.startDeviceExecution();
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVALID TYPE");

        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
    }


    @PostMapping("/resume/{iotType}")
    @ApiOperation(
            value = "start IOT to send data",
            notes = "start thread")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "ACCEPTED"),
            @ApiResponse(code = 400, message = "", response = DeviceResponse.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponse.class)})
    public ResponseEntity<String> resume(@PathVariable("iotType") @ApiParam(name = "iotType", value = "type of IOT managed",
            allowableValues = "PulseCalculator,VelocityCalculator,HomeVoice", required = true) String type) {

        switch (type) {
            case "PulseCalculator":
                PulseCalculator.resumeDeviceExecution();
                break;
            case "VelocityCalculator":
                VelocityCalculator.resumeDeviceExecution();
                break;
            case "HomeVoice":
                HomeVoice.resumeDeviceExecution();
                break;
            default:
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVALID TYPE");

        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
    }


    @PostMapping("/stop/{iotType}")
    @ApiOperation(
            value = "start IOT to send data",
            notes = "start thread")
    @ApiResponses(value = {@ApiResponse(code = 202, message = "ACCEPTED"),
            @ApiResponse(code = 400, message = "", response = DeviceResponse.class),
            @ApiResponse(code = 500, message = "Error", response = DeviceResponse.class)})
    public ResponseEntity<String> stop(@PathVariable("iotType") @ApiParam(name = "iotType", value = "type of IOT managed",
            allowableValues = "PulseCalculator,VelocityCalculator,HomeVoice", required = true) String type) {

        switch (type) {
            case "PulseCalculator":
                PulseCalculator.stopDeviceExecution();
                break;
            case "VelocityCalculator":
                VelocityCalculator.stopDeviceExecution();
                break;
            case "HomeVoice":
                HomeVoice.stopDeviceExecution();
                break;
            default:

                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("INVALID TYPE");
        }

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("SUCCESS");
    }
}
