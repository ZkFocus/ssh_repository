package com.spring.in.action.entity;

import java.sql.Date;

public class Title {

	private Integer id;
	private String message;
	private Date createDate;
	private String latitude;
	private String longitude;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	@Override
	public String toString() {
		return "Title [id=" + id + ", message=" + message + ", createDate=" + createDate + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}
	
}
