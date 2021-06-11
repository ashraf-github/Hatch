package com.internetofthings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeviceResponse {
    public Long getDeviceId() {
		return deviceId;
	}
	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}
	public DeviceResponse(Long deviceId, Long dataId, String value, LocalDateTime date) {
		super();
		this.deviceId = deviceId;
		this.dataId = dataId;
		this.value = value;
		this.date = date;
	}
	public DeviceResponse() {
		super();
	}
	public Long getDataId() {
		return dataId;
	}
	public void setDataId(Long dataId) {
		this.dataId = dataId;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public LocalDateTime getDate() {
		return date;
	}
	public void setDate(LocalDateTime date) {
		this.date = date;
	}
	private Long deviceId;
    private Long dataId;
    private String value;
    private LocalDateTime date;
}
