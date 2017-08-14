package com.hp.demo.entity;

public class Product {
	
	private String placeName;
	
	private int areaCode;
	
	private Apple apple;

	public String getPlaceName() {
		return placeName;
	}

	public void setPlaceName(String placeName) {
		this.placeName = placeName;
	}

	public int getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(int areaCode) {
		this.areaCode = areaCode;
	}

	public Apple getApple() {
		return apple;
	}

	public void setApple(Apple apple) {
		this.apple = apple;
	}

	@Override
	public String toString() {
		return "Product [placeName=" + placeName + ", areaCode=" + areaCode + ", apple=" + apple + "]";
	}

	
	
	
	
}
