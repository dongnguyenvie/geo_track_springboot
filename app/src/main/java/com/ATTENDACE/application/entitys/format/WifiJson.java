package com.ATTENDACE.application.entitys.format;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"wifi_frequency","wifi_capabilities","wifi_channel_width"})
public class WifiJson implements Serializable{
	private String wifi_ssid;
	private String wifi_bssid;
	private Integer wifi_level;
	private Integer wifi_frequency;
	private String wifi_capabilities;
	private Integer wifi_channel_width;
	
	public WifiJson() {}

	public String getWifi_ssid() {
		return wifi_ssid;
	}

	public void setWifi_ssid(String wifi_ssid) {
		this.wifi_ssid = wifi_ssid;
	}

	public String getWifi_bssid() {
		return wifi_bssid;
	}

	public void setWifi_bssid(String wifi_bssid) {
		this.wifi_bssid = wifi_bssid;
	}

	public Integer getWifi_level() {
		return wifi_level;
	}

	public void setWifi_level(Integer wifi_level) {
		this.wifi_level = wifi_level;
	}

	public Integer getWifi_frequency() {
		return wifi_frequency;
	}

	public void setWifi_frequency(Integer wifi_frequency) {
		this.wifi_frequency = wifi_frequency;
	}

	public String getWifi_capabilities() {
		return wifi_capabilities;
	}

	public void setWifi_capabilities(String wifi_capabilities) {
		this.wifi_capabilities = wifi_capabilities;
	}

	public Integer getWifi_channel_width() {
		return wifi_channel_width;
	}

	public void setWifi_channel_width(Integer wifi_channel_width) {
		this.wifi_channel_width = wifi_channel_width;
	}
	
	
	
}
