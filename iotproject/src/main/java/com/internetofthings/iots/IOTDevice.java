package com.internetofthings.iots;

public abstract class IOTDevice {

	IotApp iotApp;

    Thread thread;

    public abstract void startDeviceExecution();

    public void stopDeviceExecution(){
    	iotApp.doStop();
    }

    public void resumeDeviceExecution(){
    	iotApp.doResume();
    }
}
