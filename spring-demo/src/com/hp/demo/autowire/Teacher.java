package com.hp.demo.autowire;

public class Teacher {
	
	private String name;
	
	private Student student;
	
	private Address address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Teacher [name=" + name + ", student=" + student + ", address=" + address + "]";
	}
	
	
	

}
