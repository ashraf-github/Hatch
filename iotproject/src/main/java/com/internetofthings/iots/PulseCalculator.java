package com.internetofthings.iots;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.internetofthings.dto.DeviceReceive;

@Service
public class PulseCalculator  extends IOTDevice{

    private Logger logger = LoggerFactory.getLogger(this.getClass());


    @PostConstruct
    public void init() {
    	iotApp = new BeaterIOT();
        thread = new Thread(iotApp);
    }

    @Override
    public void startDeviceExecution() {
        thread.start();
    }


    class BeaterIOT extends IotApp {
        @Override
        public void run() {
            while (keepRunning()) {
                logger.info("The iot Device PulseCalculator is running ");

                try {
                    Double max = 200.0,min=50.0;
                    Double value = Math.floor(Math.random() * (max - min) + +min);

                    DeviceReceive input = new DeviceReceive("calculating", "SiemensCorp", "PulseCalculator", "bpm", value.toString());
                    this.sendIOTData(input);

                    Thread.sleep(1L * 3000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
