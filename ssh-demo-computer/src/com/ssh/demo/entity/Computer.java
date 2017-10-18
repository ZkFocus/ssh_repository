package com.ssh.demo.entity;

public class Computer {

	private Integer computerId;
	private String computerName;
	private String memory;
	private String cpu;
	private String videocard;
	private String display;
	private String hdd;
	private double price;
	public Integer getComputerId() {
		return computerId;
	}
	public void setComputerId(Integer computerId) {
		this.computerId = computerId;
	}
	public String getComputerName() {
		return computerName;
	}
	public void setComputerName(String computerName) {
		this.computerName = computerName;
	}
	public String getMemory() {
		return memory;
	}
	public void setMemory(String memory) {
		this.memory = memory;
	}
	public String getCpu() {
		return cpu;
	}
	public void setCpu(String cpu) {
		this.cpu = cpu;
	}
	public String getVideocard() {
		return videocard;
	}
	public void setVideocard(String videocard) {
		this.videocard = videocard;
	}
	public String getDisplay() {
		return display;
	}
	public void setDisplay(String display) {
		this.display = display;
	}
	public String getHdd() {
		return hdd;
	}
	public void setHdd(String hdd) {
		this.hdd = hdd;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
}
