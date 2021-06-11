package com.internetofthings.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class DeviceReceive {

    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "manufacturer is mandatory")
    private String manufacturer;
    @NotBlank(message = "type is mandatory")
    private String type;
    public DeviceReceive(@NotBlank(message = "Name is mandatory") String name,
			@NotBlank(message = "manufacturer is mandatory") String manufacturer,
			@NotBlank(message = "type is mandatory") String type,
			@NotBlank(message = "measureUnit is mandatory") String measureUnit,
			@NotBlank(message = "value is mandatory") String value) {
		super();
		this.name = name;
		this.manufacturer = manufacturer;
		this.type = type;
		this.measureUnit = measureUnit;
		this.value = value;
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
	public String getMeasureUnit() {
		return measureUnit;
	}
	public void setMeasureUnit(String measureUnit) {
		this.measureUnit = measureUnit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	@NotBlank(message = "measureUnit is mandatory")
    private String measureUnit;
    @NotBlank(message = "value is mandatory")
    private String value;
}
