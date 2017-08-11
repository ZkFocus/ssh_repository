package com.hp.entity.scope;

public class Apple {

	private String color;
	
	private int price;
	
	private float weight;

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

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Apple [color=" + color + ", price=" + price + ", weight=" + weight + "]";
	}
	
	
}
