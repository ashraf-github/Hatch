package com.internetofthings.iots;

import com.internetofthings.dto.DeviceReceive;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class VelocityCalculator extends IOTDevice{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @PostConstruct
    public void init() {
    	iotApp = new SpeedIOT();
        thread = new Thread(iotApp);
    }

    @Override
    public void startDeviceExecution() {
        thread.start();
    }


    class SpeedIOT extends IotApp {
        @Override
        public void run() {
            while (keepRunning()) {
                // keep doing what this thread should do.
                logger.info("running VelocityCalculator");

                try {
                    Double max = 140.0,min=0.0;
                    Double value = Math.floor(Math.random() * (max - min) + +min);

                    DeviceReceive input = new DeviceReceive("speedometer", "KimuraCorp", "VelocityCalculator", "km/h", value.toString());
                    this.sendIOTData(input);

                    Thread.sleep(1L * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

}
