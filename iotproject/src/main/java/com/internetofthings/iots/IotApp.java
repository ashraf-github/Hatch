package com.internetofthings.iots;

import com.internetofthings.dto.DeviceResponse;
import com.internetofthings.dto.DeviceReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

public abstract class IotApp implements Runnable {

    protected String applicationEndpoint = "http://localhost:8080/device/data";

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public void sendIOTData(DeviceReceive input) throws RestClientException {
        ResponseEntity<DeviceResponse> response = null;
        DeviceResponse data = null;
        try {
            response = new RestTemplate().postForEntity(applicationEndpoint, input, DeviceResponse.class);
            data = response.getBody();
        } catch (Exception e) {
            logger.error("error {}", e.getMessage());

        } finally {
            logger.info("IOT request {} response {}", input, data);
        }

    }

    protected boolean doStop = false;

    public synchronized void doStop() {
        this.doStop = true;
    }

    public synchronized void doResume() {
        this.doStop = false;
    }

    protected synchronized boolean keepRunning() {
        return this.doStop == false;
    }
}
