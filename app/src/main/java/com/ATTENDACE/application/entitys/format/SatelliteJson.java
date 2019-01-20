package com.ATTENDACE.application.entitys.format;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"sat_azimuth_degrees","sat_carrier_frequency","sat_elevation_degrees","sat_constellation_type"})
public class SatelliteJson implements Serializable{
	private Integer sat_dbhz;
	private Integer sat_svid;
	private double sat_azimuth_degrees;
	private Integer sat_carrier_frequency;
	private double sat_elevation_degrees;
	private Integer sat_constellation_type;
	
	public SatelliteJson() {}

	public Integer getSat_dbhz() {
		return sat_dbhz;
	}

	public void setSat_dbhz(Integer sat_dbhz) {
		this.sat_dbhz = sat_dbhz;
	}

	public Integer getSat_svid() {
		return sat_svid;
	}

	public void setSat_svid(Integer sat_svid) {
		this.sat_svid = sat_svid;
	}

	public double getSat_azimuth_degrees() {
		return sat_azimuth_degrees;
	}

	public void setSat_azimuth_degrees(double sat_azimuth_degrees) {
		this.sat_azimuth_degrees = sat_azimuth_degrees;
	}

	public Integer getSat_carrier_frequency() {
		return sat_carrier_frequency;
	}

	public void setSat_carrier_frequency(Integer sat_carrier_frequency) {
		this.sat_carrier_frequency = sat_carrier_frequency;
	}

	public double getSat_elevation_degrees() {
		return sat_elevation_degrees;
	}

	public void setSat_elevation_degrees(double sat_elevation_degrees) {
		this.sat_elevation_degrees = sat_elevation_degrees;
	}

	public Integer getSat_constellation_type() {
		return sat_constellation_type;
	}

	public void setSat_constellation_type(Integer sat_constellation_type) {
		this.sat_constellation_type = sat_constellation_type;
	}
	
}
