package com.ATTENDACE.application.entitys.format;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"blue_type"})
public class BlueJson implements Serializable{
	private String blue_name;
	private String blue_type;
	private String blue_level;
	private String blue_address;
	
	
	public BlueJson() {}
	
	public String getBlue_name() {
		return blue_name;
	}
	public void setBlue_name(String blue_name) {
		this.blue_name = blue_name;
	}
	public String getBlue_type() {
		return blue_type;
	}
	public void setBlue_type(String blue_type) {
		this.blue_type = blue_type;
	}
	public String getBlue_level() {
		return blue_level;
	}
	public void setBlue_level(String blue_level) {
		this.blue_level = blue_level;
	}
	public String getBlue_address() {
		return blue_address;
	}
	public void setBlue_address(String blue_address) {
		this.blue_address = blue_address;
	}
	
	
	
}
