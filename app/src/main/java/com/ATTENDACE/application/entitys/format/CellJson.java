package com.ATTENDACE.application.entitys.format;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"cell_mnc","cell_psc","cell_type"})
public class CellJson implements Serializable{
	private String cell_mnc;
	private Integer cell_psc;
	private String cell_type;
	private Integer cell_level;
	private String cell_real_id;
	
	public CellJson() {}

	public String getCell_mnc() {
		return cell_mnc;
	}

	public void setCell_mnc(String cell_mnc) {
		this.cell_mnc = cell_mnc;
	}

	public Integer getCell_psc() {
		return cell_psc;
	}

	public void setCell_psc(Integer cell_psc) {
		this.cell_psc = cell_psc;
	}

	public String getCell_type() {
		return cell_type;
	}

	public void setCell_type(String cell_type) {
		this.cell_type = cell_type;
	}

	public Integer getCell_level() {
		return cell_level;
	}

	public void setCell_level(Integer cell_level) {
		this.cell_level = cell_level;
	}

	public String getCell_real_id() {
		return cell_real_id;
	}

	public void setCell_real_id(String cell_real_id) {
		this.cell_real_id = cell_real_id;
	}
	
}
