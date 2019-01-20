package com.ATTENDACE.application.entitys;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;


import com.ATTENDACE.application.entitys.format.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.vladmihalcea.hibernate.type.array.IntArrayType;
import com.vladmihalcea.hibernate.type.array.StringArrayType;
import com.vladmihalcea.hibernate.type.json.JsonBinaryType;
import com.vladmihalcea.hibernate.type.json.JsonStringType;


/**
 * The persistent class for the geo1 database table.
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
public class Geo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="geo_id")
	private Integer geo_id;

	@Type(type ="jsonb")
	@Column(columnDefinition ="jsonb")
	private List<BlueJson> bluetooth;
	
	@Type(type ="jsonb")
	private CellJson cellular;

	@Type(type ="jsonb")
	private LocationJson locations;

	@Type(type ="jsonb")
	private List<SatelliteJson> satellite;

	@Type(type ="jsonb")
	private SensorJson sensor;

	@Type(type ="jsonb")
	private List<WifiJson> wifi;
	
	private Boolean active;
	
	@Temporal(TemporalType.DATE)
	@Column(name="post_date")
	private Date post_date;

	@Column(name="post_time")
	private Time post_time;
	

	public Geo() {
	}

	public Integer getGeo_id() {
		return geo_id;
	}

	public void setGeo_id(Integer geo_id) {
		this.geo_id = geo_id;
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

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

}