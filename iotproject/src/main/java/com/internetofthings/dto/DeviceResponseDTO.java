package com.internetofthings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DeviceResponseDTO {
    public DeviceResponseDTO(Long id, String name, String manufacturer, String type) {
		super();
		this.id = id;
		this.name = name;
		this.manufacturer = manufacturer;
		this.type = type;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	private Long id;
    private String name;
    private String manufacturer;
    private String type;
}
