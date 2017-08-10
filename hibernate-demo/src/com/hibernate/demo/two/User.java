package com.hibernate.demo.two;

import java.sql.Date;

public class User {

	private int id;
	
	private String name;
	
	private String tel;
	
	private Date birth;

	
	private Address address;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Date getBirth() {
		return birth;
	}

	public void setBirth(Date birth) {
		this.birth = birth;
	}

	
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public User(String name, String tel, Date birth) {
		super();
		this.name = name;
		this.tel = tel;
		this.birth = birth;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", tel=" + tel + ", birth=" + birth + "]";
	}
	
	
}
