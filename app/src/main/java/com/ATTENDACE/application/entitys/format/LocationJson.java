package com.ATTENDACE.application.entitys.format;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"loc_time","loc_speed","loc_bearing"})
public class LocationJson implements Serializable{
	private long loc_time;
	private double loc_speed;
	private double loc_bearing;
	private double loc_accuracy;
	private double loc_altitude;
	private double loc_latitude;
	private double loc_provider;
	private double loc_longitude;
	
	public LocationJson() {}

	public long getLoc_time() {
		return loc_time;
	}

	public void setLoc_time(long loc_time) {
		this.loc_time = loc_time;
	}

	public double getLoc_speed() {
		return loc_speed;
	}

	public void setLoc_speed(double loc_speed) {
		this.loc_speed = loc_speed;
	}

	public double getLoc_bearing() {
		return loc_bearing;
	}

	public void setLoc_bearing(double loc_bearing) {
		this.loc_bearing = loc_bearing;
	}

	public double getLoc_accuracy() {
		return loc_accuracy;
	}

	public void setLoc_accuracy(double loc_accuracy) {
		this.loc_accuracy = loc_accuracy;
	}

	public double getLoc_altitude() {
		return loc_altitude;
	}

	public void setLoc_altitude(double loc_altitude) {
		this.loc_altitude = loc_altitude;
	}

	public double getLoc_latitude() {
		return loc_latitude;
	}

	public void setLoc_latitude(double loc_latitude) {
		this.loc_latitude = loc_latitude;
	}

	public double getLoc_provider() {
		return loc_provider;
	}

	public void setLoc_provider(double loc_provider) {
		this.loc_provider = loc_provider;
	}

	public double getLoc_longitude() {
		return loc_longitude;
	}

	public void setLoc_longitude(double loc_longitude) {
		this.loc_longitude = loc_longitude;
	}
	
}
