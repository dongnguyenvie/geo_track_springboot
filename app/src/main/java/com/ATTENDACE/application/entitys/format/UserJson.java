package com.ATTENDACE.application.entitys.format;

import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class UserJson {
	private Integer us_id;
	
	private Integer track_id;
	
	private Integer place_id;
	
	private List<BlueJson> bluetooth;

	private CellJson cellular;

	private LocationJson locations;

	private Date post_date;

	private Time post_time;

	private List<SatelliteJson> satellite;

	private SensorJson sensor;

	private List<WifiJson> wifi;

	private Timestamp write_ts;
	
	public UserJson() {}

	public Integer getUs_id() {
		return us_id;
	}

	public void setUs_id(Integer us_id) {
		this.us_id = us_id;
	}

	public Integer getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
	}

	public List<BlueJson> getBluetooth() {
		return bluetooth;
	}

	public void setBluetooth(List<BlueJson> bluetooth) {
		this.bluetooth = bluetooth;
	}

	public CellJson getCellular() {
		return cellular;
	}

	public void setCellular(CellJson cellular) {
		this.cellular = cellular;
	}

	public LocationJson getLocations() {
		return locations;
	}

	public void setLocations(LocationJson locations) {
		this.locations = locations;
	}

	public Date getPost_date() {
		return post_date;
	}

	public void setPost_date(Date post_date) {
		this.post_date = post_date;
	}

	public Time getPost_time() {
		return post_time;
	}

	public void setPost_time(Time post_time) {
		this.post_time = post_time;
	}

	public List<SatelliteJson> getSatellite() {
		return satellite;
	}

	public void setSatellite(List<SatelliteJson> satellite) {
		this.satellite = satellite;
	}

	public SensorJson getSensor() {
		return sensor;
	}

	public void setSensor(SensorJson sensor) {
		this.sensor = sensor;
	}

	public List<WifiJson> getWifi() {
		return wifi;
	}

	public void setWifi(List<WifiJson> wifi) {
		this.wifi = wifi;
	}

	public Timestamp getWrite_ts() {
		return write_ts;
	}

	public void setWrite_ts(Timestamp write_ts) {
		this.write_ts = write_ts;
	}

	public Integer getPlace_id() {
		return place_id;
	}

	public void setPlace_id(Integer place_id) {
		this.place_id = place_id;
	}

	
}
