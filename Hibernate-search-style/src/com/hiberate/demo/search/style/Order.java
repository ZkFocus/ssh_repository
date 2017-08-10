package com.hiberate.demo.search.style;

public class Order {

	private Integer id;
	private String orderNo;	
	private float price;
	private Customer customer;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNo=" + orderNo + ", price=" + price + ", customer=" + customer + "]";
	}
	public Order(String orderNo, float price) {
		super();
		this.orderNo = orderNo;
		this.price = price;
	}
	public Order() {
		super();
	}
	
	
}
