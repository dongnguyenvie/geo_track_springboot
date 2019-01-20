package com.ATTENDACE.application.entitys;

import java.io.Serializable;
import javax.persistence.*;

import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;
import org.hibernate.annotations.Type;

import com.ATTENDACE.application.entitys.format.BlueJson;
import com.ATTENDACE.application.entitys.format.CellJson;
import com.ATTENDACE.application.entitys.format.LocationJson;
import com.ATTENDACE.application.entitys.format.SatelliteJson;
import com.ATTENDACE.application.entitys.format.SensorJson;
import com.ATTENDACE.application.entitys.format.WifiJson;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;


/**
 * The persistent class for the track1 database table.
 * 
 */

@Entity
@TypeDefs({
    @TypeDef(name = "string-array", typeClass = StringArrayType.class),
    @TypeDef(name = "int-array", typeClass = IntArrayType.class),
    @TypeDef(name = "json", typeClass = JsonStringType.class),
    @TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
})
@JsonIgnoreProperties({"sensor"})
public class Track implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="track_id")
	private Integer track_id;
	
	@Type(type="jsonb")
	private List<BlueJson> bluetooth;

	@Type(type="jsonb")
	private CellJson cellular;

	@Type(type="jsonb")
	private LocationJson locations;

	@Temporal(TemporalType.DATE)
	@Column(name="post_date")
	private Date post_date;

	@Column(name="post_time")
	private Time post_time;

	@Type(type="jsonb")
	private List<SatelliteJson> satellite;

	@Type(type="jsonb")
	private SensorJson sensor;

	@Type(type="jsonb")
	private List<WifiJson> wifi;

	@Column(name="write_ts")
	private Timestamp write_ts;

	public Track() {
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

	public Integer getTrack_id() {
		return track_id;
	}

	public void setTrack_id(Integer track_id) {
		this.track_id = track_id;
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




}