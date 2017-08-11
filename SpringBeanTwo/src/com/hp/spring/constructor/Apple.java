package com.hp.spring.constructor;

public class Apple {
	
	private String color;
	
	private int price;
	
	private float weight;

	public Apple(String color, int price, float weight) {
		super();
		this.color = color;
		this.price = price;
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", price=" + price + ", weight=" + weight + "]";
	}
	
	

}
