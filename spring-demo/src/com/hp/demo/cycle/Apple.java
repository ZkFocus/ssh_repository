package com.hp.demo.cycle;

public class Apple {
	private String color;
	
	private int price;

	public Apple() {
		System.out.println("Apple's constructor..........");
	}

	public void init(){
		System.out.println("init........");
	}
	
	public void destroy(){
		System.out.println("destroy.........");
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", price=" + price + "]";
	}

	

}
