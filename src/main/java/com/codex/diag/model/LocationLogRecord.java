package com.codex.diag.model;

import javax.persistence.*;

@Entity
@Table(name="tbl_location_log_records")
public class LocationLogRecord {
	@Id @GeneratedValue (strategy=GenerationType.SEQUENCE) @Column(name = "id")
	long id;
	@Column(name = "uuid") 
	String uuid;	
	@Column(name = "lat")
	double lat;
	@Column(name = "lng")
	double lng;
	@Column(name = "timestamp")
	long timestamp;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getUuid() {
		return uuid;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(double lat) {
		this.lat = lat;
	}
	public double getLng() {
		return lng;
	}
	public void setLng(double lng) {
		this.lng = lng;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
}
